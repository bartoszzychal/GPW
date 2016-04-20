package pl.bartoszzychal.starterkit.app.bank.model.utils;

import java.util.Date;

import pl.bartoszzychal.starterkit.app.bank.model.utils.enums.Execution;
import pl.bartoszzychal.starterkit.app.money.Money;

public class Confirmation {
	private Long transferFrom;
	private Long transferTo;
	private Money money;
	private Date date;
	private Execution execution;
	
	public Confirmation(Long transferFrom, Long transferTo, Money money, Date date, Execution execution) {
		this.transferFrom = transferFrom;
		this.transferTo = transferTo;
		this.money = money;
		this.date = date;
		this.execution = execution;
	}
	
	public long getTransferFrom() {
		return transferFrom;
	}
	public void setTransferFrom(long transferFrom) {
		this.transferFrom = transferFrom;
	}
	public long getTransferTo() {
		return transferTo;
	}
	public void setTransferTo(long transferTo) {
		this.transferTo = transferTo;
	}
	public Money getMoney() {
		return money;
	}
	public void setMoney(Money money) {
		this.money = money;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Execution getExecution() {
		return execution;
	}
	public void setExecution(Execution execution) {
		this.execution = execution;
	}
	
	
}
