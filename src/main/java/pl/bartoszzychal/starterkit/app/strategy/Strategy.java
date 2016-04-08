package pl.bartoszzychal.starterkit.app.strategy;

import java.util.List;

import pl.bartoszzychal.starterkit.app.broker.model.to.TransactionTo;

public interface Strategy{
	List<TransactionTo> getProposeOffer();
	boolean analyzeBrokerOffer(List<TransactionTo> transactions);
}
