package pl.bartoszzychal.starterkit.app.bank.mapper;

import java.util.Collection;
import java.util.stream.Collectors;

import pl.bartoszzychal.starterkit.app.bank.model.entity.FundsEntity;
import pl.bartoszzychal.starterkit.app.bank.model.to.FundsTo;

public class FundsMapper {
	public static FundsEntity map(FundsTo fundsTo) {
		return new FundsEntity(fundsTo.getCurrency(), fundsTo.getFund());
	}

	public static FundsTo map(FundsEntity fundsEntity) {
		return new FundsTo(fundsEntity.getId(), fundsEntity.getCurrency(), fundsEntity.getFund());
	}

	public static Collection<FundsEntity> map2Entity(Collection<FundsTo> funds) {
		return funds.stream().map(FundsMapper::map).collect(Collectors.toList());
	}

	public static Collection<FundsTo> map2To(Collection<FundsEntity> funds) {
		return funds.stream().map(FundsMapper::map).collect(Collectors.toList());
	}
}
