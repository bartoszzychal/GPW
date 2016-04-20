package pl.bartoszzychal.starterkit.app.daily.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name="daily")
public class DailyEntity {
	@Id
	@GeneratedValue
	private Long id;
	
	@Column
	private Date date;
	
	private DailyEntity() {	
	}

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}

}
