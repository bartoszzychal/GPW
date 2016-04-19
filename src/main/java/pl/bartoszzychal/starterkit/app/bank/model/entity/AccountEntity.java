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
	private long id;
	
	@Column(nullable = false, updatable = false)
	private long idClient;
	
	@GeneratedValue(strategy = GenerationType.AUTO , generator = "accountNumberGen")
	@Column(nullable = false, updatable = false)
	private long accountNumber;
	
	@GeneratedValue(strategy = GenerationType.AUTO , generator = "accountPasswordGen")
	@Column(nullable = false, updatable = false)
	private long accountPassword;
	
	@OneToMany(cascade = CascadeType.ALL ,  fetch = FetchType.LAZY)
	@JoinColumn(name = "funds")
	private Set<FundsEntity> funds = new HashSet<>();
	
	public AccountEntity() {
	}
	
	public AccountEntity(long idClient) {
		this.idClient = idClient;
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

	public long getAccountNumber() {
		return accountNumber;
	}

	public long getAccountPassword() {
		return accountPassword;
	}

	public Set<FundsEntity> getFunds() {
		return funds;
	}

	public void setFunds(Set<FundsEntity> funds) {
		this.funds = funds;
	}
}
