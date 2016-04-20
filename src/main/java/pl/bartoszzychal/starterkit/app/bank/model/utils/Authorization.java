package pl.bartoszzychal.starterkit.app.bank.model.utils;

public class Authorization {
	private Long accountNumber;
	private Long accountPassword;
	public Authorization(Long accountNumber, Long accountPassword) {
		this.accountNumber = accountNumber;
		this.accountPassword = accountPassword;
	}
	public Long getAccountNumber() {
		return accountNumber;
	}
	public Long getAccountPassword() {
		return accountPassword;
	}
	
}
