package pl.bartoszzychal.starterkit.app.bank.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import pl.bartoszzychal.starterkit.app.bank.model.enums.Currency;
import pl.bartoszzychal.starterkit.app.money.Money;

@Entity
@Table(name = "CURRENCY")
public class CurrencyEntity implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long id;

	@Column(nullable = false, updatable = false)
	Currency currency;

	@Column(nullable = false, updatable = false, scale=2)
	BigDecimal rate;

	@Column(nullable = false, updatable = false)
	LocalDate date;

	public CurrencyEntity() {
	}
	
	public CurrencyEntity(Currency currency, Money rate, LocalDate date) {
		this.currency = currency;
		this.rate = rate.getValue();
		this.date = date;
	}

	public Currency getCurrency() {
		return currency;
	}

	public Money getRate() {
		return new Money(rate);
	}

	public LocalDate getDate() {
		return date;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
}
