package pl.bartoszzychal.starterkit.app.client.model;

import pl.bartoszzychal.starterkit.app.client.model.to.ClientTo;
import pl.bartoszzychal.starterkit.app.strategy.Strategy;
import pl.bartoszzychal.starterkit.app.strategyFactory.StrategyFactory;

public class Client {
	private Long id;
	private Long accountNumber;
	private Long accountPassword;
	private Strategy strategy;
	
	public Client(ClientTo clientTo){
		this.id = clientTo.getId();
		this.accountNumber = clientTo.getAccountNumber();
		this.accountPassword = clientTo.getAccountPassword();
		this.strategy = StrategyFactory.getStrategy(id);
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public Long getAccountPassword() {
		return accountPassword;
	}
	public void setAccountPassword(Long accountPassword) {
		this.accountPassword = accountPassword;
	}
	
}
