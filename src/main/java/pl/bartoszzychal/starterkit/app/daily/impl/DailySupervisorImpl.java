package pl.bartoszzychal.starterkit.app.daily.impl;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.logstash.logback.encoder.org.apache.commons.lang.time.DateUtils;
import pl.bartoszzychal.starterkit.app.daily.DailySupervisor;
import pl.bartoszzychal.starterkit.app.daily.model.entity.DailyEntity;
import pl.bartoszzychal.starterkit.app.daily.repository.DailyRepository;

@Component
public class DailySupervisorImpl implements DailySupervisor{

	@Autowired
	private DailyRepository dailyRepository;

	private final Long idDailySupervisor = 1L;
	
	@Override
	@Transactional
	public Date nextDay() {
		 Date date = DateUtils.addDays(getCurrentDay(),1);
		 dailyRepository.nextDay(date);
		 return date;
	}


	@Override
	@Transactional
	public Date getCurrentDay() {
		 DailyEntity daily = dailyRepository.findOne(idDailySupervisor);
		 return daily.getCurrentDay();
	}


	@Override
	@Transactional
	public Date getStartDay() {
		DailyEntity daily = dailyRepository.findOne(idDailySupervisor);
		return daily.getStartDay();
	}


	@Override
	@Transactional
	public Date getEndDay() {
		DailyEntity daily = dailyRepository.findOne(idDailySupervisor);
		return daily.getEndDay();
	}

}
