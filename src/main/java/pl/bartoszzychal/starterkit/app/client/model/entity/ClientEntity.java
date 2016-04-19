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
	private long id;

	@Column(updatable = true)
	private long accountNumber;

	@Column(updatable = true)
	private long accountPassword;

	public ClientEntity() {
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

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
}
