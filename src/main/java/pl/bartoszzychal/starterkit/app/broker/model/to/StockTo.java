package pl.bartoszzychal.starterkit.app.broker.model.to;

import pl.bartoszzychal.starterkit.app.money.Money;

public class StockTo {
	
	private Long id;
	private Long clientAccountNumber;
	private Integer number;
	private CompanyTo company;
	private Money price;
	
	
	
	public StockTo(Long id, Long clientAccountNumber, Integer number, CompanyTo company, Money price) {
		this.id = id;
		this.clientAccountNumber = clientAccountNumber;
		this.number = number;
		this.company = company;
		this.price = price;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getIdClient() {
		return clientAccountNumber;
	}
	public void setIdClient(Long idClient) {
		this.clientAccountNumber = idClient;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public CompanyTo getCompany() {
		return company;
	}
	public void setCompany(CompanyTo company) {
		this.company = company;
	}

	public Money getPrice() {
		return price;
	}
	public void setPrice(Money price) {
		this.price = price;
	}
	public void setClientAccountNumber(Long clientAccountNumber) {
		this.clientAccountNumber = clientAccountNumber;
	}
	public Long getClientAccountNumber() {
		return clientAccountNumber;
	}
		
}
