package pl.bartoszzychal.starterkit.app.client.model;

import pl.bartoszzychal.starterkit.app.bank.model.utils.Authorization;
import pl.bartoszzychal.starterkit.app.bank.service.BankServiceAdapter;
import pl.bartoszzychal.starterkit.app.broker.service.BrokerServiceAdapter;
import pl.bartoszzychal.starterkit.app.client.model.to.ClientTo;
import pl.bartoszzychal.starterkit.app.strategy.Strategy;
import pl.bartoszzychal.starterkit.app.strategyFactory.StrategyFactory;

public class Client {
	private Long id;
	private Authorization authorization;
	private Strategy strategy;

	public Client(ClientTo clientTo, BrokerServiceAdapter brokerService, BankServiceAdapter bankService) {
		this.id = clientTo.getId();
		this.authorization = new Authorization(clientTo.getAccountNumber(), clientTo.getAccountPassword());
		this.strategy = StrategyFactory.getStrategy(id, authorization,brokerService, bankService);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Authorization getAuthorization() {
		return authorization;
	}

	public void setAuthorization(Authorization authorization) {
		this.authorization = authorization;
	}

	public Strategy getStrategy() {
		return strategy;
	}

}
