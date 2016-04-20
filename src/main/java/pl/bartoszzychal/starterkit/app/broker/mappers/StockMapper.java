package pl.bartoszzychal.starterkit.app.broker.mappers;

import java.util.List;
import java.util.stream.Collectors;

import pl.bartoszzychal.starterkit.app.broker.model.entity.StockEntity;
import pl.bartoszzychal.starterkit.app.broker.model.to.StockTo;

public class StockMapper {
	public static StockTo map(StockEntity stockEntity) {
		return new StockTo(stockEntity.getId(), stockEntity.getClientAccountNumber(), stockEntity.getNumber(),
				CompanyMapper.map(stockEntity.getCompany()), stockEntity.getPrice());
	}

	public static StockEntity map(StockTo stockTo) {
		return new StockEntity(stockTo.getId(), stockTo.getClientAccountNumber(), stockTo.getNumber(),
				CompanyMapper.map(stockTo.getCompany()), stockTo.getPrice());
	}

	public static List<StockTo> map2To(List<StockEntity> stockEntities) {
		return stockEntities.stream().map(StockMapper::map).collect(Collectors.toList());
	}

	public static List<StockEntity> map2Entity(List<StockTo> stockTos) {
		return stockTos.stream().map(StockMapper::map).collect(Collectors.toList());
	}
}
