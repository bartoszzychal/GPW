package pl.bartoszzychal.starterkit.app.bank.model.confirmation;

import java.time.LocalDate;

import pl.bartoszzychal.starterkit.app.bank.model.confirmation.enums.Execution;
import pl.bartoszzychal.starterkit.app.money.Money;

public class Confirmation {
	private long transferFrom;
	private long transferTo;
	private Money money;
	private LocalDate date;
	private Execution execution;
	
	public Confirmation(long transferFrom, long transferTo, Money money, LocalDate date, Execution execution) {
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
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public Execution getExecution() {
		return execution;
	}
	public void setExecution(Execution execution) {
		this.execution = execution;
	}
	
	
}
