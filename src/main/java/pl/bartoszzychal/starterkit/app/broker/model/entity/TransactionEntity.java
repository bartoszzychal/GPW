package pl.bartoszzychal.starterkit.app.broker.model.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import pl.bartoszzychal.starterkit.app.broker.model.enums.TransactionExecution;
import pl.bartoszzychal.starterkit.app.broker.model.enums.TransactionType;

@Entity
@Table(name = "TRANSACTION")
public class TransactionEntity implements Serializable {
	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false, updatable = false)
	private Long clientAccountNumber;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "stockEntity")
	private StockEntity stockEntity;

	@Column(nullable = false, updatable = false)
	private Date date;

	@Column(nullable = false)
	private TransactionType type;

	@Column(nullable = false)
	private TransactionExecution execution;

	public TransactionEntity(Long clientAccountNumber, StockEntity stockEntity, Date date, TransactionType type,
			TransactionExecution execution) {
		this.clientAccountNumber = clientAccountNumber;
		this.stockEntity = stockEntity;
		this.date = date;
		this.type = type;
		this.execution = execution;
	}

	public TransactionEntity() {
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

	public StockEntity getStockEntity() {
		return stockEntity;
	}

	public void setStockEntity(StockEntity stockEntity) {
		this.stockEntity = stockEntity;
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
