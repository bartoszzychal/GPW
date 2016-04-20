package pl.bartoszzychal.starterkit.app.bank.model.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ACCOUNT")
public class AccountEntity implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false, updatable = false)
	private Long idClient;

	@Column(nullable = false, updatable = false)
	private Long accountNumber;

	@Column(nullable = false, updatable = true)
	private Long accountPassword;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "account_id")
	private Set<FundsEntity> funds = new HashSet<>();

	public AccountEntity(Long id, Long idClient, Long accountNumber, Long accountPassword, Set<FundsEntity> funds) {
		this.id = id;
		this.idClient = idClient;
		this.accountNumber = accountNumber;
		this.accountPassword = accountPassword;
		this.funds = funds;
	}
	
	

	public AccountEntity() {
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

	public Set<FundsEntity> getFunds() {
		return funds;
	}

	public void setFunds(Set<FundsEntity> funds) {
		this.funds = funds;
	}

}
