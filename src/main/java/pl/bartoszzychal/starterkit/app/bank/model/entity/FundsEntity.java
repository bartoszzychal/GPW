package pl.bartoszzychal.starterkit.app.bank.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import pl.bartoszzychal.starterkit.app.bank.model.enums.Currency;
import pl.bartoszzychal.starterkit.app.money.Money;

@Entity
@Table(name = "FUNDS")
public class FundsEntity implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false, updatable = false)
	private Currency currency;
	
	@Column(nullable = false, scale = 2)
	private BigDecimal fund;
	

	public FundsEntity() {
	}
	
	public FundsEntity(Long id, Currency currency, Money fund) {
		this.id = id;
		this.currency = currency;
		this.fund = fund.getValue();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Money getFund() {
		return new Money(fund);
	}

	public void setFund(Money fund) {
		this.fund = fund.getValue();
	}

	public Currency getCurrency() {
		return currency;
	}
	
	public void addFund(Money money){
		this.fund.add(money.getValue());
	}

	public void substractFund(Money money){
		this.fund.subtract(money.getValue());
	}

}
