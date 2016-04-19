package pl.bartoszzychal.starterkit.app.broker.mappers;

import java.util.Collection;
import java.util.stream.Collectors;

import pl.bartoszzychal.starterkit.app.broker.model.entity.StockEntity;
import pl.bartoszzychal.starterkit.app.broker.model.to.StockTo;

public class StockMapper {
	public static StockTo map(StockEntity stockEntity) {
		return new StockTo(stockEntity.getId(), 
				stockEntity.getIdClient(), 
				stockEntity.getNumber(),
				CompanyMapper.map(stockEntity.getCompany()));
	}
	public static StockEntity map(StockTo stockTo) {
		return new StockEntity(stockTo.getIdClient(), stockTo.getNumber(),CompanyMapper.map(stockTo.getCompany()));
	}
	
	public static Collection<StockTo> map2To(Collection<StockEntity> stockEntities){
		return stockEntities.stream().map(StockMapper::map).collect(Collectors.toList());
	}
	public static Collection<StockEntity> map2Entity(Collection<StockTo> stockTos){
		return stockTos.stream().map(StockMapper::map).collect(Collectors.toList());
	}
}
