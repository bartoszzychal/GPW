package pl.bartoszzychal.starterkit.app.broker.model.entity;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "STOCK")
public class StockEntity implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private Long idClient;
	
	@Column(nullable = false)
	private Integer number;
	
	@ManyToOne(cascade = CascadeType.ALL ,  fetch = FetchType.LAZY)
	@JoinColumn(name = "company")
	private CompanyEntity company;
	
	public StockEntity(Long idClient, Integer number, CompanyEntity company) {
		this.idClient = idClient;
		this.number = number;
		this.company = company;
	}

	public StockEntity() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdClient() {
		return idClient;
	}

	public void setIdClient(Long idClient) {
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
