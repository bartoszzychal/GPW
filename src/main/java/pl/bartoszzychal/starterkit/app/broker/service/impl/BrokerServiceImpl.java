package pl.bartoszzychal.starterkit.app.broker.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.bartoszzychal.starterkit.app.bank.model.utils.Authorization;
import pl.bartoszzychal.starterkit.app.bank.model.utils.Confirmation;
import pl.bartoszzychal.starterkit.app.bank.service.BankService;
import pl.bartoszzychal.starterkit.app.broker.mappers.StockMapper;
import pl.bartoszzychal.starterkit.app.broker.mappers.StockQuotationMapper;
import pl.bartoszzychal.starterkit.app.broker.mappers.TransactionMapper;
import pl.bartoszzychal.starterkit.app.broker.model.entity.StockEntity;
import pl.bartoszzychal.starterkit.app.broker.model.entity.TransactionEntity;
import pl.bartoszzychal.starterkit.app.broker.model.enums.TransactionExecution;
import pl.bartoszzychal.starterkit.app.broker.model.enums.TransactionType;
import pl.bartoszzychal.starterkit.app.broker.model.to.StockQuotationTo;
import pl.bartoszzychal.starterkit.app.broker.model.to.StockTo;
import pl.bartoszzychal.starterkit.app.broker.model.to.TransactionTo;
import pl.bartoszzychal.starterkit.app.broker.repository.BrokerRepository;
import pl.bartoszzychal.starterkit.app.broker.repository.StockQuotationRepository;
import pl.bartoszzychal.starterkit.app.broker.repository.StockRepository;
import pl.bartoszzychal.starterkit.app.broker.repository.TransactionRepository;
import pl.bartoszzychal.starterkit.app.broker.service.BrokerService;
import pl.bartoszzychal.starterkit.app.daily.CurrentDay;
import pl.bartoszzychal.starterkit.app.money.Money;

@Service
@Transactional(readOnly = true)
public class BrokerServiceImpl implements BrokerService {
	
	@Autowired
	private TransactionRepository transactionRepository;
	@Autowired
	private StockRepository stockRepository;
	@Autowired
	private StockQuotationRepository stockQuotationRepository;
	@Autowired
	private BrokerRepository brokerRepository;
	@Autowired
	private CurrentDay currentDay;
	@Autowired
	private BankService bankService;

	
	@Transactional(readOnly = false)
	private List<TransactionTo> addTransactions(List<TransactionTo> transactionTos){
		return TransactionMapper.map2To(transactionRepository.save(TransactionMapper.map2Entity(transactionTos)));
	}

	@Transactional(readOnly = false)
	private List<TransactionEntity> updateTransactionsStatus(List<TransactionEntity> transactionEntities) {
			List<Long> ids = transactionEntities.stream().map((transaction)->transaction.getId()).collect(Collectors.toList());
			List<TransactionEntity> transactionsInDB = transactionRepository.findAll(ids);
			for (TransactionEntity transactionEntity : transactionsInDB) {
				transactionEntity.setExecution(TransactionExecution.YES);
			}
			return transactionEntities;
	}	

	@Override
	@Transactional
	public List<StockQuotationTo> getTodayStockQuotation() {
		Date date = currentDay.getCurrentDay();
		return StockQuotationMapper.map2To(stockQuotationRepository.getTodayStockQuotation(date));
	}

	@Override
	@Transactional
	public List<StockQuotationTo> getStockQuotationFrom(Date lowerdate, Date upperdate) {
		Date date = currentDay.getCurrentDay();
		if(upperdate.after(date)){
			upperdate = date;
		}
		return StockQuotationMapper.map2To(stockQuotationRepository.getStockQuotationFrom(lowerdate, upperdate));
	}

	@Override
	@Transactional
	public List<StockTo> getAllClientStocks(Long clientAcountNumber) {
		return StockMapper.map2To(stockRepository.getClientStocks(clientAcountNumber));
	}

	@Override
	@Transactional
	public Long getBrokerAccountNumber() {
		return brokerRepository.findAll().get(0).getAccountNumber();
	}

	@Transactional(readOnly = false)
	private List<StockEntity> addStocksClient(List<StockEntity> stockEntities) {
		return stockRepository.save(stockEntities);
	}
	@Override
	@Transactional(readOnly = false)
	public List<TransactionTo> prepareOffer(List<TransactionTo> transaction) {
		Random r = new Random();
		int rangePrice = 2;
		int rangeStockNumber = 20;
		int randomPriceSell = (100-rangePrice)  + r.nextInt(100-(100-rangePrice)+1);
		int randomPriceBuy = 100  + r.nextInt((100+rangePrice)-100+1);
		int randomStockNumber = (100-rangeStockNumber) + r.nextInt(100-(100-rangeStockNumber)+1);
		List<TransactionEntity> transactionEntities = TransactionMapper.map2Entity(transaction);
		Map<TransactionType, List<TransactionEntity>> groupingByTransType = transactionEntities.stream().collect(Collectors.groupingBy(TransactionEntity::getType));
		List<StockEntity> buyStock = getStockEntityFromTransactionList(groupingByTransType, TransactionType.BUY);
		for (StockEntity stockEntity : buyStock) {
			stockEntity.setNumber((stockEntity.getNumber()*randomStockNumber)/100);
			stockEntity.setPrice((stockEntity.getPrice().multiply(randomPriceBuy)).divide(100));
		}
		List<StockEntity> sellStock = getStockEntityFromTransactionList(groupingByTransType, TransactionType.SELL);
		for (StockEntity stockEntity : sellStock) {
			stockEntity.setNumber((stockEntity.getNumber()*randomStockNumber)/100);
			stockEntity.setPrice((stockEntity.getPrice().multiply(randomPriceSell)).divide(100));
		}
		return TransactionMapper.map2To(transactionRepository.save(transactionEntities));
	}
	
	@Override
	@Transactional(readOnly = false)
	public Confirmation responseOffer(Confirmation confirmation,Boolean response) {
		Confirmation brokerConfirmation = null;
		Date date = currentDay.getCurrentDay();
		if(Boolean.FALSE == response){
			return null;
		}
		else if(Boolean.TRUE == response && confirmation.getTransferTo() == getBrokerAccountNumber()){
			Long clientAccountNumber = confirmation.getTransferFrom();
			List<TransactionEntity> todayTransactions = transactionRepository.getTodayTransactions(date, clientAccountNumber);
			List<StockEntity> clientStocks = getClientStocks(clientAccountNumber);
			Map<TransactionType, List<TransactionEntity>> groupingByTransType = todayTransactions.stream().collect(Collectors.groupingBy(TransactionEntity::getType));
			List<StockEntity> buyStock = getStockEntityFromTransactionList(groupingByTransType, TransactionType.BUY);
			List<StockEntity> sellStock = getStockEntityFromTransactionList(groupingByTransType, TransactionType.SELL);
			Money moneyBuy = sum(buyStock);
			Money fees = calculateFees(TransactionMapper.map2To(todayTransactions));
			Money sellingCounter = new Money(new BigDecimal(0));
			if(confirmation.getMoney().equals(moneyBuy.add(fees))){
				addStocksClient(buyStock);
				sellingCounter = calculateMoneySell(clientStocks, sellStock);
				updateTransactionsStatus(todayTransactions);
			}
			brokerConfirmation = bankService.transfer(new Authorization(getBrokerAccountNumber(), getBrokerPassword()), sellingCounter, clientAccountNumber);
		}
		return brokerConfirmation;
	}

	private Money calculateMoneySell(List<StockEntity> clientStocks, List<StockEntity> sellStock) {
		Money sellingCounter = new Money(new BigDecimal(0));
		for (StockEntity toSell : sellStock) {
			for (StockEntity actualStock: clientStocks) {
				if(checkStockCompanyName(toSell, actualStock)){
					if(checkAvailability(toSell, actualStock)){
						actualStock.setNumber(toSell.getNumber());
						sellingCounter.add(toSell.getPrice().multiply(toSell.getNumber()));
					}			
				}
			}
		}
		return sellingCounter;
	}

	private boolean checkAvailability(StockEntity toSell, StockEntity actualStock) {
		return actualStock.getNumber()>=toSell.getNumber();
	}

	private boolean checkStockCompanyName(StockEntity toSell, StockEntity actualStock) {
		return toSell.getCompany().getName().equals(actualStock.getCompany().getName());
	}

	private Money sum(List<StockEntity> stockEntities){
		return stockEntities.stream().map((se)-> se.getPrice().multiply(se.getNumber())).reduce((m1,m2)->m1.add(m2)).get();
	}
	
	private List<StockEntity> getStockEntityFromTransactionList(Map<TransactionType, List<TransactionEntity>> groupingByTransType,TransactionType type){
		return groupingByTransType.get(type).stream().map((t)->t.getStockEntity()).collect(Collectors.toList());
	}
	
	private List<StockEntity> getClientStocks(Long id){
		return stockRepository.findAll(stockRepository.getClientStocks(id).stream().map(StockEntity::getId).collect(Collectors.toList()));
	}
	
	private Long getBrokerPassword() {
		return brokerRepository.findAll().get(0).getAccountPassword();
	}

	@Override
	public Money calculateFees(List<TransactionTo> transaction) {
		Money minimal = new Money(new BigDecimal(5));
		Money fees = transaction
		.stream()
		.map(t->t.getStockTo())
		.map(st->st.getPrice().multiply(st.getNumber()) // all
				.multiply(5) //brokerage 0,5%
				.divide(1000))
		.reduce((m1,m2)->m1.add(m2)).get();
		return Money.max(fees, minimal);
	}


	
	
}
