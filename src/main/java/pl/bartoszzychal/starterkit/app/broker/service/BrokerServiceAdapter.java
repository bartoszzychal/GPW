package pl.bartoszzychal.starterkit.app.broker.service;

import java.util.Date;
import java.util.List;

import pl.bartoszzychal.starterkit.app.broker.model.to.StockQuotationTo;
import pl.bartoszzychal.starterkit.app.broker.model.to.StockTo;
import pl.bartoszzychal.starterkit.app.broker.model.to.TransactionTo;
import pl.bartoszzychal.starterkit.app.money.Money;

public interface BrokerServiceAdapter {
	List<StockTo> getAllClientStocks(Long id);
	List<StockQuotationTo> getTodayStockQuotation();
	List<StockQuotationTo> getStockQuotationFrom(Date lowerdate, Date upperdate);
	Money calculateFees(List<TransactionTo> transaction);
}
