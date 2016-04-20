package pl.bartoszzychal.starterkit.app.bank.service;

import java.util.List;

import pl.bartoszzychal.starterkit.app.bank.model.enums.Currency;
import pl.bartoszzychal.starterkit.app.bank.model.to.FundsTo;
import pl.bartoszzychal.starterkit.app.bank.model.utils.Authorization;
import pl.bartoszzychal.starterkit.app.bank.model.utils.Confirmation;
import pl.bartoszzychal.starterkit.app.money.Money;

public interface BankService {
	Money getCurrentExchangeRate(Currency from, Currency to);
	List<FundsTo> exchange(Authorization authorization, Currency from,Currency to, Money money);
	List<FundsTo> getFunds(Authorization authorization);
	Confirmation transfer(Authorization authorization, Money money, Long transferTo);
}
