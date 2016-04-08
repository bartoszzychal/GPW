package pl.bartoszzychal.starterkit.app.broker.model.entity;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "COMPANY")
public class CompanyEntity implements Serializable{
	@Id
	@GeneratedValue
	long id;
}
