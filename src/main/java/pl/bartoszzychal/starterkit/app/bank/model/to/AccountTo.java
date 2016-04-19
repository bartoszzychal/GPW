package pl.bartoszzychal.starterkit.app.bank.model.to;

import java.util.HashSet;
import java.util.Set;

public class AccountTo {
	
	private Long id;
	private Long idClient;
	private Long accountNumber;
	private Long accountPassword;
	private Set<FundsTo> funds = new HashSet<>();
	
	
	public AccountTo(Long id, Long idClient, Long accountNumber, Long accountPassword, Set<FundsTo> funds) {
		this.id = id;
		this.idClient = idClient;
		this.accountNumber = accountNumber;
		this.accountPassword = accountPassword;
		this.funds = funds;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getIdClient() {
		return idClient;
	}
	public void setIdClient(Long idClient) {
		this.idClient = idClient;
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
	public Set<FundsTo> getFunds() {
		return funds;
	}
	public void setFunds(Set<FundsTo> funds) {
		this.funds = funds;
	}
}
