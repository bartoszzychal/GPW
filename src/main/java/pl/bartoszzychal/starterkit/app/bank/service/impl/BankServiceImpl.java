package pl.bartoszzychal.starterkit.app.bank.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.bartoszzychal.starterkit.app.bank.mapper.FundsMapper;
import pl.bartoszzychal.starterkit.app.bank.model.entity.AccountEntity;
import pl.bartoszzychal.starterkit.app.bank.model.entity.CurrencyEntity;
import pl.bartoszzychal.starterkit.app.bank.model.entity.FundsEntity;
import pl.bartoszzychal.starterkit.app.bank.model.enums.Currency;
import pl.bartoszzychal.starterkit.app.bank.model.to.FundsTo;
import pl.bartoszzychal.starterkit.app.bank.model.utils.Authorization;
import pl.bartoszzychal.starterkit.app.bank.model.utils.Confirmation;
import pl.bartoszzychal.starterkit.app.bank.repository.AccountRepository;
import pl.bartoszzychal.starterkit.app.bank.repository.CurrencyRepository;
import pl.bartoszzychal.starterkit.app.bank.service.BankService;
import pl.bartoszzychal.starterkit.app.daily.CurrentDay;
import pl.bartoszzychal.starterkit.app.money.Money;

@Service
@Transactional(readOnly = true)
public class BankServiceImpl implements BankService {

	@Autowired
	private AccountRepository accountRepository;
	@Autowired 
	private CurrencyRepository currencyRepository;
	@Autowired
	private CurrentDay currentDay;
	
	@Override
	public Money getCurrentExchangeRate(Currency from, Currency to) {
		Date currentDate = currentDay.getCurrentDay();
		CurrencyEntity currencyFrom = currencyRepository.getCurrencyFromDay(currentDate, from);
		CurrencyEntity currencyTo = currencyRepository.getCurrencyFromDay(currentDate, to);
		Money rateFrom = currencyFrom.getRate();
		Money rateTo = currencyTo.getRate();
		Money rateFromWithBrokerage = rateFrom.multiply(102).divide(100);
		Money rate = rateTo.divide(rateFromWithBrokerage);
		return rate;
	}

	@Override
	public List<FundsTo> exchange(Authorization authorization, Currency from, Currency to, Money money) {
		AccountEntity account = accountRepository.getAccount(authorization.getAccountNumber());
		if(account.getAccountPassword().equals(authorization.getAccountPassword())){
			Set<FundsEntity> funds = account.getFunds();
			Money currentExchangeRate = getCurrentExchangeRate(from, to);
			Money ToTake = new Money(money.getValue());
			Money toAdd = money.divide(currentExchangeRate);

			funds.stream().filter((fund) -> fund.getCurrency() == from).findFirst().get().substractFund(ToTake);
			funds.stream().filter((fund) -> fund.getCurrency() == to).findFirst().get().addFund(toAdd);
		}
		return FundsMapper.map2To(account.getFunds().stream().collect(Collectors.toList()));
	}

	@Override
	public List<FundsTo> getFunds(Authorization authorization) {
		AccountEntity account = accountRepository.getAccount(authorization.getAccountNumber());
		List<FundsTo> fundsTos = new ArrayList<>();
		if(account.getAccountPassword().equals(authorization.getAccountPassword())){
			Set<FundsEntity> funds = account.getFunds();
			fundsTos.addAll(FundsMapper.map2To(funds.stream().collect(Collectors.toList())));
		}
		return fundsTos;
	}

	@Override
	public Confirmation transfer(Authorization authorization, Money money, Long transferTo) {
		// TODO Auto-generated method stub
		return null;
	}


}
