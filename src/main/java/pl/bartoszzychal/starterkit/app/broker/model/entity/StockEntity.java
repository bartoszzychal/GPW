package pl.bartoszzychal.starterkit.app.broker.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.*;

import pl.bartoszzychal.starterkit.app.money.Money;

@Entity
@Table(name = "STOCK")
public class StockEntity implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = true)
	private Long clientAccountNumber;
	
	@Column(nullable = false)
	private Integer number;
	
	@ManyToOne(cascade = CascadeType.ALL ,  fetch = FetchType.LAZY)
	@JoinColumn(name = "company")
	private CompanyEntity company;
	
	@Column(nullable = false, scale = 2)
	private BigDecimal price;
	
	public StockEntity(Long id, Long clientAccountNumber, Integer number, CompanyEntity company, Money price) {
		this.id = id;
		this.clientAccountNumber = clientAccountNumber;
		this.number = number;
		this.company = company;
		this.price = price.getValue();
	}
	
	

	public StockEntity() {
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
}
