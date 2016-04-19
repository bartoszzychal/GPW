package pl.bartoszzychal.starterkit.app.broker.model.entity;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "COMPANY")
public class CompanyEntity implements Serializable{	
	
	@Id
	@Column(nullable = false, updatable = false, length = 100, unique= true)
	private String name;
	
	public CompanyEntity(String name) {
		this.name = name;
	}
	
	public CompanyEntity() {
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
