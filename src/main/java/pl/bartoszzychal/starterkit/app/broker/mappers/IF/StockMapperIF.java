package pl.bartoszzychal.starterkit.app.broker.mappers.IF;

import java.util.List;
import java.util.stream.Collectors;

import pl.bartoszzychal.starterkit.app.broker.mappers.StockMapper;
import pl.bartoszzychal.starterkit.app.broker.model.entity.StockEntity;
import pl.bartoszzychal.starterkit.app.broker.model.to.StockTo;

public interface StockMapperIF {

	StockTo map(StockEntity stockEntity);

	StockEntity map(StockTo stockTo);

	List<StockTo> map2To(List<StockEntity> stockEntities);

	List<StockEntity> map2Entity(List<StockTo> stockTos);
}
