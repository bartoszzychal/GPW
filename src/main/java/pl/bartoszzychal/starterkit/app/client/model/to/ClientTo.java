package pl.bartoszzychal.starterkit.app.client.model.to;

public class ClientTo {
	private Long id;
	private Long accountNumber;
	private Long accountPassword;
	
	public ClientTo(Long id, Long accountNumber, Long accountPassword) {
		this.id = id;
		this.accountNumber = accountNumber;
		this.accountPassword = accountPassword;
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
