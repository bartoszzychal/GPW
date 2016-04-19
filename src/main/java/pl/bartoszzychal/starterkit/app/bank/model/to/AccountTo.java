package pl.bartoszzychal.starterkit.app.bank.model.to;

import java.util.HashSet;
import java.util.Set;

public class AccountTo {
	
	private long id;
	private long idClient;
	private long accountNumber;
	private long accountPassword;
	private Set<FundsTo> funds = new HashSet<>();
	
	
	public AccountTo(long id, long idClient, long accountNumber, long accountPassword, Set<FundsTo> funds) {
		this.id = id;
		this.idClient = idClient;
		this.accountNumber = accountNumber;
		this.accountPassword = accountPassword;
		this.funds = funds;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getIdClient() {
		return idClient;
	}
	public void setIdClient(long idClient) {
		this.idClient = idClient;
	}
	public long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public long getAccountPassword() {
		return accountPassword;
	}
	public void setAccountPassword(long accountPassword) {
		this.accountPassword = accountPassword;
	}
	public Set<FundsTo> getFunds() {
		return funds;
	}
	public void setFunds(Set<FundsTo> funds) {
		this.funds = funds;
	}
}
