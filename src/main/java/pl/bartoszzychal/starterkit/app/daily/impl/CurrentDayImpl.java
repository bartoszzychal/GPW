package pl.bartoszzychal.starterkit.app.daily.impl;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pl.bartoszzychal.starterkit.app.daily.CurrentDay;
import pl.bartoszzychal.starterkit.app.daily.DailySupervisor;

@Component
public class CurrentDayImpl implements CurrentDay{

	@Autowired
	private DailySupervisor DailySupervisor;
	
	@Override
	public LocalDate getCurrentDay() {
		return DailySupervisor.getCurrentDay();
	}

}
