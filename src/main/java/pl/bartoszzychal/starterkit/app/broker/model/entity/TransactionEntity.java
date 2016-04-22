package pl.bartoszzychal.starterkit.app.broker.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import pl.bartoszzychal.starterkit.app.broker.model.enums.TransactionExecution;
import pl.bartoszzychal.starterkit.app.broker.model.enums.TransactionType;
import pl.bartoszzychal.starterkit.app.money.Money;

@Entity
@Table(name = "TRANSACTION")
public class TransactionEntity implements Serializable {
	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false, updatable = false)
	private Long clientAccountNumber;

	@Column(nullable = false)
	private Integer number;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "company")
	private CompanyEntity company;
	
	@Column(nullable = false, scale = 2)
	private BigDecimal price;

	@Column(nullable = false, updatable = false)
	private Date date;

	@Column(nullable = false)
	private TransactionType type;

	@Column(nullable = false)
	private TransactionExecution execution;


	public TransactionEntity() {
	}
	
	public TransactionEntity(Long id, Long clientAccountNumber, Integer number, CompanyEntity company, Money price,
			Date date, TransactionType type, TransactionExecution execution) {
		this.id = id;
		this.clientAccountNumber = clientAccountNumber;
		this.number = number;
		this.company = company;
		this.price = price.getValue();
		this.date = date;
		this.type = type;
		this.execution = execution;
	}



	public Long getClientAccountNumber() {
		return clientAccountNumber;
	}

	public void setClientAccountNumber(Long clientAccountNumber) {
		this.clientAccountNumber = clientAccountNumber;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public CompanyEntity getCompany() {
		return company;
	}

	public void setCompany(CompanyEntity company) {
		this.company = company;
	}

	public Money getPrice() {
		return new Money(price);
	}

	public void setPrice(Money price) {
		this.price = price.getValue();
	}

	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdClient() {
		return clientAccountNumber;
	}

	public void setIdClient(Long idClient) {
		this.clientAccountNumber = idClient;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public TransactionType getType() {
		return type;
	}

	public void setType(TransactionType type) {
		this.type = type;
	}

	public TransactionExecution getExecution() {
		return execution;
	}

	public void setExecution(TransactionExecution execution) {
		this.execution = execution;
	}

}
