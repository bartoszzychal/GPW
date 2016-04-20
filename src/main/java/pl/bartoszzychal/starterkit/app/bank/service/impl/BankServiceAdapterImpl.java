package pl.bartoszzychal.starterkit.app.bank.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.bartoszzychal.starterkit.app.bank.model.enums.Currency;
import pl.bartoszzychal.starterkit.app.bank.model.to.FundsTo;
import pl.bartoszzychal.starterkit.app.bank.model.utils.Authorization;
import pl.bartoszzychal.starterkit.app.bank.service.BankService;
import pl.bartoszzychal.starterkit.app.bank.service.BankServiceAdapter;
import pl.bartoszzychal.starterkit.app.money.Money;

@Service
public class BankServiceAdapterImpl implements BankServiceAdapter {

	@Autowired
	private BankService bankService;

	@Override
	public Money getCurrentExchangeRate(Currency from, Currency to) {
		return bankService.getCurrentExchangeRate(from, to);
	}

	@Override
	public List<FundsTo> getFunds(Authorization authorization) {
		return bankService.getFunds(authorization);
	}

}
