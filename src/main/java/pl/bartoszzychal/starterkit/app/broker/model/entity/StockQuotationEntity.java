package pl.bartoszzychal.starterkit.app.broker.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import pl.bartoszzychal.starterkit.app.bank.model.entity.FundsEntity;
import pl.bartoszzychal.starterkit.app.money.Money;

@Entity
@Table(name = "STOCK_QUOTATION")
public class StockQuotationEntity implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(nullable = false, updatable= false )
	private LocalDate date;
	
	@Column(nullable = false, scale = 2, updatable = false)
	private BigDecimal quotation;
	
	@ManyToOne(cascade = CascadeType.ALL ,  fetch = FetchType.LAZY)
	@JoinColumn(name = "company")
	private CompanyEntity company;
	
	
	public StockQuotationEntity(LocalDate date, Money quotation, CompanyEntity company) {
		this.date = date;
		this.quotation = quotation.getValue();
		this.company = company;
	}
	
	public StockQuotationEntity() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Money getQuotation() {
		return new Money(quotation);
	}

	public void setQuotation(Money quotation) {
		this.quotation = quotation.getValue();
	}

	public CompanyEntity getCompany() {
		return company;
	}

	public void setCompany(CompanyEntity company) {
		this.company = company;
	}
	
	
}
