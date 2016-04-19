package pl.bartoszzychal.starterkit.app.broker.mappers;

import java.util.List;
import java.util.stream.Collectors;

import pl.bartoszzychal.starterkit.app.broker.model.entity.StockQuotationEntity;
import pl.bartoszzychal.starterkit.app.broker.model.to.StockQuotationTo;

public class StockQuotationMapper {
	public static StockQuotationEntity map(StockQuotationTo stockQuotationTo){
		return new StockQuotationEntity(stockQuotationTo.getDate(), 
				stockQuotationTo.getQuotation(), 
				CompanyMapper.map(stockQuotationTo.getCompany()));
	}
	
	public static StockQuotationTo map(StockQuotationEntity stockQuotationEntity){
		return new StockQuotationTo(stockQuotationEntity.getId(), 
				stockQuotationEntity.getDate(), 
				stockQuotationEntity.getQuotation(),
				CompanyMapper.map(stockQuotationEntity.getCompany()));
	}
	
	public static List<StockQuotationEntity> map2Entity(List<StockQuotationTo> stockQuotationTos){
		return stockQuotationTos.stream().map(StockQuotationMapper::map).collect(Collectors.toList());
	}
	public static List<StockQuotationTo> map2To(List<StockQuotationEntity> stockQuotationEntities){
		return stockQuotationEntities.stream().map(StockQuotationMapper::map).collect(Collectors.toList());
	}
}
