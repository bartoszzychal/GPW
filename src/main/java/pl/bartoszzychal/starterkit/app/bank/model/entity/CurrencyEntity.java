package pl.bartoszzychal.starterkit.app.bank.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

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
	private Long id;

	@Column(nullable = false, updatable = false)
	private Currency currency;

	@Column(nullable = false, updatable = false, scale=2)
	private BigDecimal rate;

	@Column(nullable = false, updatable = false)
	private Date date;

	public CurrencyEntity() {
	}
	
	public CurrencyEntity(Long id, Currency currency, BigDecimal rate, Date date) {
		this.id = id;
		this.currency = currency;
		this.rate = rate;
		this.date = date;
	}

	public Currency getCurrency() {
		return currency;
	}

	public Money getRate() {
		return new Money(rate);
	}

	public Date getDate() {
		return date;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
