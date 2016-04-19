package pl.bartoszzychal.starterkit.app.bank.model.to;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import pl.bartoszzychal.starterkit.app.bank.model.enums.Currency;
import pl.bartoszzychal.starterkit.app.money.Money;

public class FundsTo {
	private long id;
	private Currency currency;
	private Money fund;
	
	public FundsTo(long id, Currency currency, Money fund) {
		this.id = id;
		this.currency = currency;
		this.fund = fund;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	public Money getFund() {
		return fund;
	}

	public void setFund(Money fund) {
		this.fund = fund;
	}
}
