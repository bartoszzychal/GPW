package pl.bartoszzychal.starterkit.app.client.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CLIENT")
public class ClientEntity {
	@Id
	@GeneratedValue
	long id;
}
