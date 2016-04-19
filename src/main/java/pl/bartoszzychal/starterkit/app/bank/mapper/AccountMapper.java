package pl.bartoszzychal.starterkit.app.bank.mapper;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import pl.bartoszzychal.starterkit.app.bank.model.entity.AccountEntity;
import pl.bartoszzychal.starterkit.app.bank.model.entity.FundsEntity;
import pl.bartoszzychal.starterkit.app.bank.model.to.AccountTo;

public class AccountMapper {
	public static AccountEntity map(AccountTo accountTo){
		Set<FundsEntity> funds = FundsMapper.map2Entity(accountTo.getFunds()).stream().collect(Collectors.toSet());
		AccountEntity accountEntity = new AccountEntity(accountTo.getId(),
				accountTo.getIdClient(),
				accountTo.getAccountNumber(),
				accountTo.getAccountPassword(),
				funds);
		return accountEntity;
	}
	
	public static AccountTo map(AccountEntity accountEntity){
		return new AccountTo(accountEntity.getId(), 
				accountEntity.getIdClient(), 
				accountEntity.getAccountNumber(), 
				accountEntity.getAccountPassword(),
				FundsMapper.map2To(accountEntity.getFunds()).stream().collect(Collectors.toSet()));
	}
	
	public static Collection<AccountEntity> map2Entity(Collection<AccountTo> accountTos){
		return accountTos.stream().map(AccountMapper::map).collect(Collectors.toList());
	}
	
	public static Collection<AccountTo> map2To(Collection<AccountEntity> accountEntities){
		return accountEntities.stream().map(AccountMapper::map).collect(Collectors.toList());
	}
}
