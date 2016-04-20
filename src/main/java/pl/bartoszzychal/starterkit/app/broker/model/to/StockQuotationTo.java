package pl.bartoszzychal.starterkit.app.broker.model.to;

import java.util.Date;

import pl.bartoszzychal.starterkit.app.money.Money;

public class StockQuotationTo {
	private Long id;
	private Date date;
	private Money quotation;
	private CompanyTo company;

	public StockQuotationTo(Long id, Date date, Money quotation, CompanyTo company) {
		this.id = id;
		this.date = date;
		this.quotation = quotation;
		this.company = company;
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
		return quotation;
	}
	public void setQuotation(Money quotation) {
		this.quotation = quotation;
	}
	public CompanyTo getCompany() {
		return company;
	}
	public void setCompany(CompanyTo company) {
		this.company = company;
	}
	
	
	
}
