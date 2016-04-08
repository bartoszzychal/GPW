package pl.bartoszzychal.starterkit.app.bank.service;

import pl.bartoszzychal.starterkit.app.money.Money;

public interface BankService extends BankServiceAdapter{
	Money getCurrentExchangeRate(String from);
}
