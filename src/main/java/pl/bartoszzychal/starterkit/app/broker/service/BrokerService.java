package pl.bartoszzychal.starterkit.app.broker.service;

import java.util.Date;
import java.util.List;

import pl.bartoszzychal.starterkit.app.bank.model.utils.Confirmation;
import pl.bartoszzychal.starterkit.app.broker.model.to.StockQuotationTo;
import pl.bartoszzychal.starterkit.app.broker.model.to.StockTo;
import pl.bartoszzychal.starterkit.app.broker.model.to.TransactionTo;
import pl.bartoszzychal.starterkit.app.money.Money;

public interface BrokerService{
	List<StockTo> getAllClientStocks(Long id);
	List<StockQuotationTo> getTodayStockQuotation();
	List<StockQuotationTo> getStockQuotationFrom(Date lowerdate, Date upperdate);
	Long getBrokerAccountNumber();
	Confirmation responseOffer(Confirmation confirmation,Boolean response);
	List<TransactionTo> prepareOffer(List<TransactionTo> transaction);
	Money calculateFees(List<TransactionTo> transaction);
}
