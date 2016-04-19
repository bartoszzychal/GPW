package pl.bartoszzychal.starterkit.app.broker.model.to;

import java.time.LocalDate;

import pl.bartoszzychal.starterkit.app.money.Money;

public class StockQuotationTo {
	private long id;
	private LocalDate date;
	private Money quotation;
	private CompanyTo company;

	public StockQuotationTo(long id, LocalDate date, Money quotation, CompanyTo company) {
		this.id = id;
		this.date = date;
		this.quotation = quotation;
		this.company = company;
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
