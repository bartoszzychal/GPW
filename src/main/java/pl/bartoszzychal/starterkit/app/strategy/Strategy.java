package pl.bartoszzychal.starterkit.app.strategy;

import java.util.List;

import pl.bartoszzychal.starterkit.app.broker.model.to.TransactionTo;

public interface Strategy{
	List<TransactionTo> suggestTransactions();
	boolean analyzeBrokerOffer(List<TransactionTo> transactions);
}
