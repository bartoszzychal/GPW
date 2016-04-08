package pl.bartoszzychal.starterkit.app.broker.model.entity;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "STOCK")
public class StockEntity implements Serializable {
	@Id
	@GeneratedValue
	long id;
}
