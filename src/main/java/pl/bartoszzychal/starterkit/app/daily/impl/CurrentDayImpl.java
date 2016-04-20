package pl.bartoszzychal.starterkit.app.daily.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pl.bartoszzychal.starterkit.app.daily.CurrentDay;
import pl.bartoszzychal.starterkit.app.daily.DailySupervisor;

@Component
public class CurrentDayImpl implements CurrentDay{

	@Autowired
	private DailySupervisor dailySupervisor;
	
	@Override
	public Date getCurrentDay() {
		return dailySupervisor.getCurrentDay();
	}

}
