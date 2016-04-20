package pl.bartoszzychal.starterkit.app.strategy.impl;

import java.util.List;

import pl.bartoszzychal.starterkit.app.bank.model.utils.Authorization;
import pl.bartoszzychal.starterkit.app.bank.service.BankServiceAdapter;
import pl.bartoszzychal.starterkit.app.broker.model.to.TransactionTo;
import pl.bartoszzychal.starterkit.app.broker.service.BrokerServiceAdapter;

public class LargeBrainStrategy extends AbstractStrategy{

	public LargeBrainStrategy(Authorization authorization, BrokerServiceAdapter brokerService,
			BankServiceAdapter bankService) {
		super(authorization, brokerService, bankService);
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
