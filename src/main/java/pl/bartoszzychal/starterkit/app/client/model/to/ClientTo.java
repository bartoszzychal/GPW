package pl.bartoszzychal.starterkit.app.client.model.to;

public class ClientTo {
	private long id;
	private long accountNumber;
	private long accountPassword;
	
	public ClientTo(long id, long accountNumber, long accountPassword) {
		this.id = id;
		this.accountNumber = accountNumber;
		this.accountPassword = accountPassword;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
	
	

}
