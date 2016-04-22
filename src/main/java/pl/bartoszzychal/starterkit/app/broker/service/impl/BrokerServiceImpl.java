package pl.bartoszzychal.starterkit.app.broker.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
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
import pl.bartoszzychal.starterkit.app.broker.mappers.IF.StockMapperIF;
import pl.bartoszzychal.starterkit.app.broker.mappers.IF.StockQuotationMapperIF;
import pl.bartoszzychal.starterkit.app.broker.mappers.IF.TransactionMapperIF;
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
	@Autowired
	private TransactionMapperIF transactionMapper;
	@Autowired 
	private StockQuotationMapperIF stockQuotationMapper;
	@Autowired 
	private StockMapperIF stockMapper;
	
	@Transactional(readOnly = false)
	private List<TransactionTo> addTransactions(List<TransactionTo> transactionTos){
		return transactionMapper.map2To(transactionRepository.save(transactionMapper.map2Entity(transactionTos)));
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
		return stockQuotationMapper.map2To(stockQuotationRepository.getTodayStockQuotation(date));
	}

	@Override
	@Transactional
	public List<StockQuotationTo> getStockQuotationFrom(Date lowerdate, Date upperdate) {
		Date date = currentDay.getCurrentDay();
		if(upperdate.after(date)){
			upperdate = date;
		}
		return stockQuotationMapper.map2To(stockQuotationRepository.getStockQuotationFrom(lowerdate, upperdate));
	}

	@Override
	@Transactional
	public List<StockTo> getAllClientStocks(Long clientAcountNumber) {
		return stockMapper.map2To(stockRepository.getClientStocks(clientAcountNumber));
	}

	@Override
	@Transactional
	public Long getBrokerAccountNumber() {
		return brokerRepository.findAll().get(0).getAccountNumber();
	}

	@Transactional(readOnly = false)
	private List<StockEntity> addStocksClient(List<TransactionEntity> transactionEntities) {
		List<StockEntity> stockEntities = new ArrayList<>();
		for (TransactionEntity transactionEntity : transactionEntities) {
			StockEntity stockEntity = new StockEntity(null, transactionEntity.getClientAccountNumber(),transactionEntity.getNumber(),transactionEntity.getCompany(),transactionEntity.getPrice());
			stockEntities.add(stockEntity);
		}
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
		List<TransactionEntity> transactionEntities = transactionMapper.map2Entity(transaction);
		Map<TransactionType, List<TransactionEntity>> groupingByTransType = transactionEntities.stream().collect(Collectors.groupingBy(TransactionEntity::getType));
		List<TransactionEntity> buyTransaction = getByTypeFromTransactionList(groupingByTransType, TransactionType.BUY);
		if(buyTransaction!= null){
			for (TransactionEntity trans : buyTransaction) {
				trans.setNumber((trans.getNumber()*randomStockNumber)/100);
				trans.setPrice((trans.getPrice().multiply(randomPriceBuy)).divide(100));
			}			
		}
		List<TransactionEntity> sellStock = getByTypeFromTransactionList(groupingByTransType, TransactionType.SELL);
		if(sellStock!=null){
			for (TransactionEntity trans : sellStock) {
				trans.setNumber((trans.getNumber()*randomStockNumber)/100);
				trans.setPrice((trans.getPrice().multiply(randomPriceSell)).divide(100));
			}			
		}
		return transactionMapper.map2To(transactionRepository.save(transactionEntities));
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
			List<TransactionEntity> transactionBuy = getByTypeFromTransactionList(groupingByTransType, TransactionType.BUY);
			List<TransactionEntity> transactionSell = getByTypeFromTransactionList(groupingByTransType, TransactionType.SELL);
			Money moneyBuy = sum(transactionBuy);
			Money fees = calculateFees(transactionMapper.map2To(todayTransactions));
			Money sellingCounter = new Money(new BigDecimal(0));
			if(confirmation.getMoney().equals(moneyBuy.add(fees))){
				if(transactionBuy!= null){
					addStocksClient(transactionBuy);					
				}
				if(transactionSell!=null){
					sellingCounter = calculateMoneySell(clientStocks, transactionSell);					
				}
				updateTransactionsStatus(todayTransactions);
			}
			brokerConfirmation = bankService.transfer(new Authorization(getBrokerAccountNumber(), getBrokerPassword()), sellingCounter, clientAccountNumber);
		}
		return brokerConfirmation;
	}
	
	private List<TransactionEntity> getByTypeFromTransactionList(Map<TransactionType, List<TransactionEntity>> groupingByTransType,TransactionType type){
		return groupingByTransType.get(type);
	}

	private Money calculateMoneySell(List<StockEntity> clientStocks, List<TransactionEntity> transactionEntities) {
		Money sellingCounter = new Money(new BigDecimal(0));
		for (TransactionEntity toSell : transactionEntities) {
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

	private boolean checkAvailability(TransactionEntity toSell, StockEntity actualStock) {
		return actualStock.getNumber()>=toSell.getNumber();
	}

	private boolean checkStockCompanyName(TransactionEntity toSell, StockEntity actualStock) {
		return toSell.getCompany().getName().equals(actualStock.getCompany().getName());
	}

	private Money sum(List<TransactionEntity> transactionEntities){
		if(transactionEntities!=null){
			return transactionEntities.stream().map((t)-> t.getPrice().multiply(t.getNumber())).reduce((m1,m2)->m1.add(m2)).get();			
		}
		return new Money(new BigDecimal(0));
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
		.map(st->st.getPrice().multiply(st.getNumber()) // all
				.multiply(5) //brokerage 0,5%
				.divide(1000))
		.reduce((m1,m2)->m1.add(m2)).get();
		return Money.max(fees, minimal);
	}


	
	
}
