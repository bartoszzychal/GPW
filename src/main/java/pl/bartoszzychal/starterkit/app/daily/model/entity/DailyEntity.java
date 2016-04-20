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
	private Date startDay;
	
	@Column
	private Date endDay;

	@Column 
	private Date currentDay;
	

	private DailyEntity() {	
	}

	public Date getStartDay() {
		return startDay;
	}

	public Date getEndDay() {
		return endDay;
	}

	public Date getCurrentDay() {
		return currentDay;
	}

	public void setCurrentDay(Date currentDay) {
		this.currentDay = currentDay;
	}
		
}
