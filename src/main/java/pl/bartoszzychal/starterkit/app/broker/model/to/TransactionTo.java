package pl.bartoszzychal.starterkit.app.broker.model.to;

import java.util.Date;

import pl.bartoszzychal.starterkit.app.broker.model.enums.TransactionExecution;
import pl.bartoszzychal.starterkit.app.broker.model.enums.TransactionType;
import pl.bartoszzychal.starterkit.app.money.Money;

public class TransactionTo {
	private Long id;
	private Long clientAccountNumber;
	private Integer number;
	private CompanyTo company;
	private Money price;
	private Date date;
	private TransactionType type;
	private TransactionExecution execution;
	
	public TransactionTo(Long id, Long clientAccountNumber, Integer number, CompanyTo company, Money price, Date date,
			TransactionType type, TransactionExecution execution) {
		this.id = id;
		this.clientAccountNumber = clientAccountNumber;
		this.number = number;
		this.company = company;
		this.price = price;
		this.date = date;
		this.type = type;
		this.execution = execution;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getClientAccountNumber() {
		return clientAccountNumber;
	}
	public void setClientAccountNumber(Long clientAccountNumber) {
		this.clientAccountNumber = clientAccountNumber;
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
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public TransactionType getType() {
		return type;
	}
	public void setType(TransactionType type) {
		this.type = type;
	}
	public TransactionExecution getExecution() {
		return execution;
	}
	public void setExecution(TransactionExecution execution) {
		this.execution = execution;
	}
	

	
	
}
