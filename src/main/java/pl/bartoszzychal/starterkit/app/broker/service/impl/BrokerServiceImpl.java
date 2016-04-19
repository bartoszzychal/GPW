package pl.bartoszzychal.starterkit.app.broker.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;

import pl.bartoszzychal.starterkit.app.broker.mappers.StockMapper;
import pl.bartoszzychal.starterkit.app.broker.mappers.StockQuotationMapper;
import pl.bartoszzychal.starterkit.app.broker.mappers.TransactionMapper;
import pl.bartoszzychal.starterkit.app.broker.model.entity.StockEntity;
import pl.bartoszzychal.starterkit.app.broker.model.entity.StockQuotationEntity;
import pl.bartoszzychal.starterkit.app.broker.model.entity.TransactionEntity;
import pl.bartoszzychal.starterkit.app.broker.model.to.StockQuotationTo;
import pl.bartoszzychal.starterkit.app.broker.model.to.StockTo;
import pl.bartoszzychal.starterkit.app.broker.model.to.TransactionTo;
import pl.bartoszzychal.starterkit.app.broker.repository.StockQuotationRepository;
import pl.bartoszzychal.starterkit.app.broker.repository.StockRepository;
import pl.bartoszzychal.starterkit.app.broker.repository.TransactionRepository;
import pl.bartoszzychal.starterkit.app.broker.service.BrokerService;

public class BrokerServiceImpl implements BrokerService {
	
	@Autowired
	private TransactionRepository transactionRepository;
	@Autowired
	private StockRepository stockRepository;
	@Autowired
	private StockQuotationRepository stockQuotationRepository;
	
	@Override
	@Transactional
	public List<TransactionTo> addTransactions(List<TransactionTo> transactionTos){
		return TransactionMapper.map2To(transactionRepository.save(TransactionMapper.map2Entity(transactionTos)));
	}

	@Override
	@Transactional
	public List<TransactionTo> updateTransactionsStatus(List<TransactionTo> transactionTos) {
		return transactionTos
		.stream()
		.map(TransactionMapper::map)
		.filter((transaction)-> transactionRepository.exists(transaction.getId()))
		.map((transaction)-> transactionRepository.findOne(transaction.getId()))
		.map((transaction)-> transactionRepository.save(transaction))
		.map(TransactionMapper::map)
		.collect(Collectors.toList());
	}

	@Override
	@Transactional
	public List<StockTo> addStocksClient(List<StockTo> stockTos) {
		return StockMapper.map2To((stockRepository.save(StockMapper.map2Entity(stockTos))));
	}

	@Override
	@Transactional
	public List<StockQuotationTo> getTodayStockQuotation(Date date) {
		return StockQuotationMapper.map2To(stockQuotationRepository.getTodayStockQuotation(date));
	}

	@Override
	@Transactional
	public List<StockQuotationTo> getStockQuotationFrom(Date lowerdate, Date upperdate) {
		return StockQuotationMapper.map2To(stockQuotationRepository.getStockQuotationFrom(lowerdate, upperdate));
	}
		
}
