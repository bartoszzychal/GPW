package pl.bartoszzychal.starterkit.app.broker.model.entity;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "COMPANY")
public class CompanyEntity implements Serializable{
	@Id
	@GeneratedValue
	private long id;
	
	@Column(nullable = false, updatable = false, length = 100)
	private String name;
	
	public CompanyEntity(String name) {
		this.name = name;
	}
	
	public CompanyEntity() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
