package pl.bartoszzychal.starterkit.app.strategy.impl;

import java.util.List;

import pl.bartoszzychal.starterkit.app.bank.model.utils.Authorization;
import pl.bartoszzychal.starterkit.app.bank.service.BankServiceAdapter;
import pl.bartoszzychal.starterkit.app.broker.model.to.TransactionTo;
import pl.bartoszzychal.starterkit.app.broker.service.BrokerServiceAdapter;
import pl.bartoszzychal.starterkit.app.strategy.Strategy;

public abstract class AbstractStrategy implements Strategy {
	
	protected Authorization authorization;
	protected BrokerServiceAdapter brokerService;
	protected BankServiceAdapter bankService;
	public AbstractStrategy(Authorization authorization, BrokerServiceAdapter brokerService, BankServiceAdapter bankService) {
		this.authorization = authorization;
		this.brokerService = brokerService;
		this.bankService = bankService;
	}
	

}
