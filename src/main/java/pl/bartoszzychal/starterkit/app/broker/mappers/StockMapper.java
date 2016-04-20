package pl.bartoszzychal.starterkit.app.broker.mappers;

import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import pl.bartoszzychal.starterkit.app.broker.mappers.IF.CompanyMapperIF;
import pl.bartoszzychal.starterkit.app.broker.mappers.IF.StockMapperIF;
import pl.bartoszzychal.starterkit.app.broker.model.entity.StockEntity;
import pl.bartoszzychal.starterkit.app.broker.model.to.StockTo;

@Component
public class StockMapper implements StockMapperIF {

	private StockMapperIF stockMapper;
	@Autowired
    private ApplicationContext applicationContext;
	
	@PostConstruct
	private void init() {
		stockMapper= applicationContext.getBean(StockMapper.class);
	}

	@Autowired
	private CompanyMapperIF companyMapper;

	public StockTo map(StockEntity stockEntity) {
		return new StockTo(stockEntity.getId(), stockEntity.getClientAccountNumber(), stockEntity.getNumber(),
				companyMapper.map(stockEntity.getCompany()), stockEntity.getPrice());
	}

	public StockEntity map(StockTo stockTo) {
		return new StockEntity(stockTo.getId(), stockTo.getClientAccountNumber(), stockTo.getNumber(),
				companyMapper.map(stockTo.getCompany()), stockTo.getPrice());
	}

	public List<StockTo> map2To(List<StockEntity> stockEntities) {
		return stockEntities.stream().map(e -> stockMapper.map(e)).collect(Collectors.toList());
	}

	public List<StockEntity> map2Entity(List<StockTo> stockTos) {
		return stockTos.stream().map(e -> stockMapper.map(e)).collect(Collectors.toList());
	}
}
