package pl.bartoszzychal.starterkit.app.client.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CLIENT")
public class ClientEntity {
	@Id
	@GeneratedValue
	private Long id;

	@Column(updatable = true)
	private Long accountNumber;

	@Column(updatable = true)
	private Long accountPassword;

	public ClientEntity() {
	}
	
	public ClientEntity(Long id, Long accountNumber, Long accountPassword) {
		this.id = id;
		this.accountNumber = accountNumber;
		this.accountPassword = accountPassword;
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
