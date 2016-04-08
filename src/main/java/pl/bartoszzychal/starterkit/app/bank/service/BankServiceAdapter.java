package pl.bartoszzychal.starterkit.app.bank.service;

import pl.bartoszzychal.starterkit.app.money.Money;

public interface BankServiceAdapter {
	Money getCurrentExchangeRate(String from,String on);
}
