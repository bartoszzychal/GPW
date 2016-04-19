package pl.bartoszzychal.starterkit.app.broker.service;

import java.util.Date;
import java.util.List;

import pl.bartoszzychal.starterkit.app.broker.model.to.StockQuotationTo;
import pl.bartoszzychal.starterkit.app.broker.model.to.StockTo;
import pl.bartoszzychal.starterkit.app.broker.model.to.TransactionTo;

public interface BrokerService extends BrokerServiceAdapter {
	List<TransactionTo> addTransactions(List<TransactionTo> transactionTos);
	List<TransactionTo> updateTransactionsStatus(List<TransactionTo> transactionTos);
	List<StockTo> addStocksClient(List<StockTo> stockTos);
	List<StockQuotationTo> getTodayStockQuotation(Date date);
	List<StockQuotationTo> getStockQuotationFrom(Date lowerdate, Date upperdate);


}
