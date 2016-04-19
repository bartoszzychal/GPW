package pl.bartoszzychal.starterkit.app.broker.model.entity;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "STOCK")
public class StockEntity implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(nullable = false)
	private long idClient;
	
	@Column(nullable = false)
	private Integer number;
	
	@ManyToOne(cascade = CascadeType.ALL ,  fetch = FetchType.LAZY)
	@JoinColumn(name = "company")
	private CompanyEntity company;
	
	public StockEntity(long idClient, Integer number, CompanyEntity company) {
		this.idClient = idClient;
		this.number = number;
		this.company = company;
	}

	public StockEntity() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getIdClient() {
		return idClient;
	}

	public void setIdClient(long idClient) {
		this.idClient = idClient;
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
	
	
}
