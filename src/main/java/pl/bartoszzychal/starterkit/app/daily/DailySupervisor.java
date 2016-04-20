package pl.bartoszzychal.starterkit.app.daily;

import java.util.Date;

public interface DailySupervisor{
	Date nextDay();
	Date getStartDay();
	Date getEndDay();
	Date getCurrentDay();
}
