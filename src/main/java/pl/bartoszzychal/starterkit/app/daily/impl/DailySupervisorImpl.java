package pl.bartoszzychal.starterkit.app.daily.impl;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import org.springframework.stereotype.Component;

import pl.bartoszzychal.starterkit.app.daily.DailySupervisor;

@Component
public class DailySupervisorImpl implements DailySupervisor{

	private LocalDate currentDay;

	@Override
	public LocalDate nextDay() {
		currentDay = currentDay.plus(1,ChronoUnit.DAYS);
		return currentDay;
	}

	@Override
	public LocalDate setStartDay(LocalDate startDay) {
		currentDay = startDay;
		return currentDay;
	}

	@Override
	public LocalDate getCurrentDay() {
		return currentDay;
	}

}
