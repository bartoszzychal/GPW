package pl.bartoszzychal.starterkit.app.strategy.impl;

import java.util.List;

import pl.bartoszzychal.starterkit.app.bank.model.utils.Authorization;
import pl.bartoszzychal.starterkit.app.bank.service.BankServiceAdapter;
import pl.bartoszzychal.starterkit.app.broker.model.to.TransactionTo;
import pl.bartoszzychal.starterkit.app.broker.service.BrokerServiceAdapter;

public class MediumBrainStrategy extends AbstractStrategy {

	public MediumBrainStrategy(Authorization authorization, BrokerServiceAdapter brokerService,
			BankServiceAdapter bankService) {
		super(authorization, brokerService, bankService);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<TransactionTo> suggestTransactions() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean analyzeBrokerOffer(List<TransactionTo> transactions) {
		// TODO Auto-generated method stub
		return false;
	}

}
