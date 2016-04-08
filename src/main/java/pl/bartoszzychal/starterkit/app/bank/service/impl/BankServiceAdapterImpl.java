package pl.bartoszzychal.starterkit.app.bank.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import pl.bartoszzychal.starterkit.app.bank.service.BankService;
import pl.bartoszzychal.starterkit.app.bank.service.BankServiceAdapter;
import pl.bartoszzychal.starterkit.app.money.Money;

public class BankServiceAdapterImpl implements BankServiceAdapter {

	@Autowired
	private BankService bankService;
	
	@Override
	public Money getCurrentExchangeRate(String from, String on) {
		return bankService.getCurrentExchangeRate(from, on);
	}
}
