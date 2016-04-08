package pl.bartoszzychal.starterkit.app.bank.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "FUNDS")
public class FundsEntity implements Serializable {
	@Id
	@GeneratedValue
	long id;
}
