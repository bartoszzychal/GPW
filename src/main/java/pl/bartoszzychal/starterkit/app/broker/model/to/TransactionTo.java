package pl.bartoszzychal.starterkit.app.broker.model.to;

import java.time.LocalDate;

import pl.bartoszzychal.starterkit.app.broker.model.entity.StockEntity;
import pl.bartoszzychal.starterkit.app.broker.model.enums.TransactionExecution;
import pl.bartoszzychal.starterkit.app.broker.model.enums.TransactionType;

public class TransactionTo {
	private long id;
	private long idClient;
	private StockTo stockTo;
	private LocalDate date;
	private TransactionType type;
	private TransactionExecution execution;
	
	public TransactionTo(long id, long idClient, StockTo stockTo, LocalDate date, TransactionType type,
			TransactionExecution execution) {
		this.id = id;
		this.idClient = idClient;
		this.stockTo = stockTo;
		this.date = date;
		this.type = type;
		this.execution = execution;
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
	public StockTo getStockEntity() {
		return stockTo;
	}
	public void setStockEntity(StockTo stockTo) {
		this.stockTo = stockTo;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
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
