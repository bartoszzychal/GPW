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

@Entity
@Table(name = "FUNDS")
public class FundsEntity implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(nullable = false, updatable = false)
	private Currency currency;
	
	@Column(nullable = false, scale = 2)
	private BigDecimal fund;
	

	public FundsEntity() {
	}
	
	public FundsEntity(Currency currency, BigDecimal fund) {
		this.currency = currency;
		this.fund = fund;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public BigDecimal getFund() {
		return fund;
	}

	public void setFund(BigDecimal fund) {
		this.fund = fund;
	}

	public Currency getCurrency() {
		return currency;
	}

}
