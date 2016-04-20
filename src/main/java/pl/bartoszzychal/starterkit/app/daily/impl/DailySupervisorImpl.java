package pl.bartoszzychal.starterkit.app.daily.impl;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pl.bartoszzychal.starterkit.app.daily.DailySupervisor;
import pl.bartoszzychal.starterkit.app.daily.repository.DailyRepository;

@Component
public class DailySupervisorImpl implements DailySupervisor{

	@Autowired
	private DailyRepository dailyRepository;

	private  Long idDailySupervisor = 1L;
	
	@Override
	@Transactional
	public Date nextDay() {
		 idDailySupervisor++;
		 return getCurrentDay();
	}

	@Override
	@Transactional
	public Date getCurrentDay() {
		return dailyRepository.findOne(idDailySupervisor).getDate();
	}
}
