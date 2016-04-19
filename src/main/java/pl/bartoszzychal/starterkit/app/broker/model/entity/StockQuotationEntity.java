package pl.bartoszzychal.starterkit.app.broker.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import pl.bartoszzychal.starterkit.app.money.Money;

@Entity
@Table(name = "STOCK_QUOTATION")
public class StockQuotationEntity implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false, updatable= false )
	private Date date;
	
	@Column(nullable = false, scale = 2, updatable = false)
	private BigDecimal quotation;
	
	@ManyToOne(cascade = CascadeType.ALL ,  fetch = FetchType.LAZY)
	@JoinColumn(name = "company")
	private CompanyEntity company;
	
	
	public StockQuotationEntity(Date date, Money quotation, CompanyEntity company) {
		this.date = date;
		this.quotation = quotation.getValue();
		this.company = company;
	}
	
	public StockQuotationEntity() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
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
