package pl.bartoszzychal.starterkit.app.broker.model.to;

public class StockTo {
	
	private Long id;
	private Long idClient;
	private Integer number;
	private CompanyTo company;
	
	public StockTo(Long id, Long idClient, Integer number, CompanyTo company) {
		this.id = id;
		this.idClient = idClient;
		this.number = number;
		this.company = company;
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
	public CompanyTo getCompany() {
		return company;
	}
	public void setCompany(CompanyTo company) {
		this.company = company;
	}
	
}
