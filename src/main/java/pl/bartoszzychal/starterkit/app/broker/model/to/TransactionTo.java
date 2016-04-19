package pl.bartoszzychal.starterkit.app.broker.model.to;

import java.time.LocalDate;
import java.util.Date;

import pl.bartoszzychal.starterkit.app.broker.model.enums.TransactionExecution;
import pl.bartoszzychal.starterkit.app.broker.model.enums.TransactionType;

public class TransactionTo {
	private Long id;
	private Long idClient;
	private StockTo stockTo;
	private Date date;
	private TransactionType type;
	private TransactionExecution execution;
	
	public TransactionTo(Long id, Long idClient, StockTo stockTo, Date date, TransactionType type,
			TransactionExecution execution) {
		this.id = id;
		this.idClient = idClient;
		this.stockTo = stockTo;
		this.date = date;
		this.type = type;
		this.execution = execution;
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
	public StockTo getStockEntity() {
		return stockTo;
	}
	public void setStockEntity(StockTo stockTo) {
		this.stockTo = stockTo;
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
