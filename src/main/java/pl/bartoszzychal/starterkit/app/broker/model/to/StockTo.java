package pl.bartoszzychal.starterkit.app.broker.model.to;

public class StockTo {
	
	private long id;
	private long idClient;
	private Integer number;
	private CompanyTo company;
	
	public StockTo(long id, long idClient, Integer number, CompanyTo company) {
		this.id = id;
		this.idClient = idClient;
		this.number = number;
		this.company = company;
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
	public CompanyTo getCompany() {
		return company;
	}
	public void setCompany(CompanyTo company) {
		this.company = company;
	}
	
}
