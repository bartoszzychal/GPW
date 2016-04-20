package pl.bartoszzychal.starterkit.app.broker.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.bartoszzychal.starterkit.app.broker.model.to.StockQuotationTo;
import pl.bartoszzychal.starterkit.app.broker.model.to.StockTo;
import pl.bartoszzychal.starterkit.app.broker.model.to.TransactionTo;
import pl.bartoszzychal.starterkit.app.broker.service.BrokerService;
import pl.bartoszzychal.starterkit.app.broker.service.BrokerServiceAdapter;
import pl.bartoszzychal.starterkit.app.money.Money;

@Service
public class BrokerServiceAdapterImpl implements BrokerServiceAdapter {
	
	@Autowired
	private BrokerService brokerService;

	@Override
	public List<StockTo> getAllClientStocks(Long id) {
		return brokerService.getAllClientStocks(id);
	}

	@Override
	public List<StockQuotationTo> getTodayStockQuotation() {
		return brokerService.getTodayStockQuotation();
	}

	@Override
	public List<StockQuotationTo> getStockQuotationFrom(Date lowerdate, Date upperdate) {
		return brokerService.getStockQuotationFrom(lowerdate, upperdate);
	}

	@Override
	public Money calculateFees(List<TransactionTo> transaction) {
		return brokerService.calculateFees(transaction);
	}
}
