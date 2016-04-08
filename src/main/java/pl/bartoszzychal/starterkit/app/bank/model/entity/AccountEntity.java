package pl.bartoszzychal.starterkit.app.bank.model.entity;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "ACCOUNT")
public class AccountEntity implements Serializable {
	@Id
	@GeneratedValue
	long id;
}
