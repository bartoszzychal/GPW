package pl.bartoszzychal.starterkit.app.bank.model.to;

import pl.bartoszzychal.starterkit.app.bank.model.enums.Currency;
import pl.bartoszzychal.starterkit.app.money.Money;

public class FundsTo {
	private Long id;
	private Currency currency;
	private Money fund;
	
	public FundsTo(Long id, Currency currency, Money fund) {
		this.id = id;
		this.currency = currency;
		this.fund = fund;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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
