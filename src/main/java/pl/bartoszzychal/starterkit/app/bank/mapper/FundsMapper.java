package pl.bartoszzychal.starterkit.app.bank.mapper;

import java.util.List;
import java.util.stream.Collectors;

import pl.bartoszzychal.starterkit.app.bank.model.entity.FundsEntity;
import pl.bartoszzychal.starterkit.app.bank.model.to.FundsTo;

public class FundsMapper {
	public static FundsEntity map(FundsTo fundsTo) {
		return new FundsEntity(fundsTo.getId(), fundsTo.getCurrency(), fundsTo.getFund());
	}

	public static FundsTo map(FundsEntity fundsEntity) {
		return new FundsTo(fundsEntity.getId(), fundsEntity.getCurrency(), fundsEntity.getFund());
	}

	public static List<FundsEntity> map2Entity(List<FundsTo> funds) {
		return funds.stream().map(FundsMapper::map).collect(Collectors.toList());
	}

	public static List<FundsTo> map2To(List<FundsEntity> funds) {
		return funds.stream().map(FundsMapper::map).collect(Collectors.toList());
	}
}
