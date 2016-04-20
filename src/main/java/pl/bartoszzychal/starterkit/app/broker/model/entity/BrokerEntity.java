package pl.bartoszzychal.starterkit.app.broker.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "BROKER")
public class BrokerEntity {
	@Id
	@GeneratedValue
	private Long id;

	@Column(updatable = true)
	private Long accountNumber;

	@Column(updatable = true)
	private Long accountPassword;

	
	public BrokerEntity(Long id, Long accountNumber, Long accountPassword) {
		this.id = id;
		this.accountNumber = accountNumber;
		this.accountPassword = accountPassword;
	}
	
	

	public BrokerEntity() {
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
