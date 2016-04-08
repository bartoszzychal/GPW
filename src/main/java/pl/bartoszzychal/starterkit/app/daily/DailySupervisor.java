package pl.bartoszzychal.starterkit.app.daily;

import java.time.LocalDate;

public interface DailySupervisor extends CurrentDay{
	LocalDate nextDay();
	LocalDate setStartDay(LocalDate startDay);
}
