package pl.bartoszzychal.starterkit.app.strategy.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import pl.bartoszzychal.starterkit.app.bank.model.enums.Currency;
import pl.bartoszzychal.starterkit.app.bank.model.to.FundsTo;
import pl.bartoszzychal.starterkit.app.bank.model.utils.Authorization;
import pl.bartoszzychal.starterkit.app.bank.model.utils.enums.Execution;
import pl.bartoszzychal.starterkit.app.bank.service.BankServiceAdapter;
import pl.bartoszzychal.starterkit.app.broker.model.enums.TransactionExecution;
import pl.bartoszzychal.starterkit.app.broker.model.enums.TransactionType;
import pl.bartoszzychal.starterkit.app.broker.model.to.StockQuotationTo;
import pl.bartoszzychal.starterkit.app.broker.model.to.StockTo;
import pl.bartoszzychal.starterkit.app.broker.model.to.TransactionTo;
import pl.bartoszzychal.starterkit.app.broker.service.BrokerServiceAdapter;
import pl.bartoszzychal.starterkit.app.money.Money;
import pl.bartoszzychal.starterkit.app.strategy.Strategy;

public class SmallBrainStrategy extends AbstractStrategy {

	private static final int BUY_NUMBER = 5;


	public SmallBrainStrategy(Authorization authorization, BrokerServiceAdapter brokerService,
			BankServiceAdapter bankService) {
		super(authorization, brokerService, bankService);
	}

	@Override
	public List<TransactionTo> suggestTransactions() {
		List<StockQuotationTo> todayStockQuotation = brokerService.getTodayStockQuotation();
		List<StockTo> allClientStocks = brokerService.getAllClientStocks(authorization.getAccountNumber());
		
		
		List<TransactionTo> suggestingTransactions = new ArrayList<>();
		suggestSellTransactions(todayStockQuotation, allClientStocks, suggestingTransactions);
		suggestBuyTransactions(todayStockQuotation, suggestingTransactions);
		return suggestingTransactions;
	}

	private void suggestBuyTransactions(List<StockQuotationTo> todayStockQuotation,
			List<TransactionTo> suggestingTransactions) {
		Money funds = getFunds();
		Money used = new Money(new BigDecimal(0));
		for (StockQuotationTo stockQuotationTo :todayStockQuotation) {
			Money needed = stockQuotationTo.getQuotation().multiply(BUY_NUMBER);
			if(Money.max(funds, used.add(needed)).equals(funds)){
				used = used.add(needed);
				StockTo stockTo = new StockTo(null, null, BUY_NUMBER, stockQuotationTo.getCompany(), stockQuotationTo.getQuotation());
				suggestingTransactions.add(new TransactionTo(null, authorization.getAccountNumber(),stockTo , stockQuotationTo.getDate(), TransactionType.BUY, TransactionExecution.NO));
			}
		}

	}

	private Money getFunds(){
		List<FundsTo> funds = bankService.getFunds(authorization);
		Money currentExchangeRate = bankService.getCurrentExchangeRate(Currency.EURO, Currency.PLN);
		Money euro = getFunds(funds,Currency.EURO);
		Money pln = getFunds(funds,Currency.PLN);
		return euro.multiply(currentExchangeRate).add(pln);
	}
	
	private Money getFunds(List<FundsTo> funds,Currency currency) {
		return funds.stream().filter(f-> f.getCurrency()==currency).findFirst().get().getFund();
	}
	
	private void suggestSellTransactions(List<StockQuotationTo> todayStockQuotation, List<StockTo> allClientStocks,
			List<TransactionTo> suggestingTransactions) {
		for (StockTo stockTo : allClientStocks) {
			for(StockQuotationTo stockQuotationTo: todayStockQuotation){
				if(stockTo.getCompany().getName().equals(stockQuotationTo.getCompany().getName())){
					Money quotation = stockQuotationTo.getQuotation().multiply(101).divide(100);
					Money price = stockTo.getPrice();
					Money max = Money.max(quotation, price);
					if(max.equals(quotation)){
						suggestingTransactions.add(new TransactionTo(null, authorization.getAccountNumber(),stockTo,stockQuotationTo.getDate(), TransactionType.SELL, TransactionExecution.NO));
					}
				}
			}
		}
	}
	

	@Override
	public boolean analyzeBrokerOffer(List<TransactionTo> transactions) {
		return true;
	}

}
