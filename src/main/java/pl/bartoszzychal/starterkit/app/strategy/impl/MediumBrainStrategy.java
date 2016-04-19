package pl.bartoszzychal.starterkit.app.strategy.impl;

import java.util.List;

import pl.bartoszzychal.starterkit.app.broker.model.to.TransactionTo;
import pl.bartoszzychal.starterkit.app.strategy.Strategy;

public class MediumBrainStrategy implements Strategy {

	@Override
	public List<TransactionTo> getProposeOffer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean analyzeBrokerOffer(List<TransactionTo> transactions) {
		// TODO Auto-generated method stub
		return false;
	}

}
