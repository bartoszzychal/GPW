package pl.bartoszzychal.starterkit.app.broker.mappers.IF;

import java.util.List;

import pl.bartoszzychal.starterkit.app.broker.model.entity.StockQuotationEntity;
import pl.bartoszzychal.starterkit.app.broker.model.to.StockQuotationTo;

public interface StockQuotationMapperIF {

	StockQuotationEntity map(StockQuotationTo stockQuotationTo);

	StockQuotationTo map(StockQuotationEntity stockQuotationEntity);

	List<StockQuotationEntity> map2Entity(List<StockQuotationTo> stockQuotationTos);

	List<StockQuotationTo> map2To(List<StockQuotationEntity> stockQuotationEntities);
}
