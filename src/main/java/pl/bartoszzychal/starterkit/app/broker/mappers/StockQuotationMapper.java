package pl.bartoszzychal.starterkit.app.broker.mappers;

import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import pl.bartoszzychal.starterkit.app.broker.mappers.IF.CompanyMapperIF;
import pl.bartoszzychal.starterkit.app.broker.mappers.IF.StockMapperIF;
import pl.bartoszzychal.starterkit.app.broker.mappers.IF.StockQuotationMapperIF;
import pl.bartoszzychal.starterkit.app.broker.model.entity.StockQuotationEntity;
import pl.bartoszzychal.starterkit.app.broker.model.to.StockQuotationTo;

@Component
public class StockQuotationMapper implements StockQuotationMapperIF {

	@Autowired
	private CompanyMapperIF companyMapper;
	
	@Autowired
    private ApplicationContext applicationContext;
	
	@PostConstruct
	private void init() {
		stockQuotationMapper= applicationContext.getBean(StockQuotationMapper.class);
	}
	
	private StockQuotationMapperIF stockQuotationMapper;
	
	public StockQuotationEntity map(StockQuotationTo stockQuotationTo){
		return new StockQuotationEntity(stockQuotationTo.getDate(), 
				stockQuotationTo.getQuotation(), 
				companyMapper.map(stockQuotationTo.getCompany()));
	}
	
	public StockQuotationTo map(StockQuotationEntity stockQuotationEntity){
		return new StockQuotationTo(stockQuotationEntity.getId(), 
				stockQuotationEntity.getDate(), 
				stockQuotationEntity.getQuotation(),
				companyMapper.map(stockQuotationEntity.getCompany()));
	}
	
	public  List<StockQuotationEntity> map2Entity(List<StockQuotationTo> stockQuotationTos){
		return stockQuotationTos.stream().map(stockQuotationto ->stockQuotationMapper.map(stockQuotationto)).collect(Collectors.toList());
	}
	public  List<StockQuotationTo> map2To(List<StockQuotationEntity> stockQuotationEntities){
		return stockQuotationEntities.stream().map(stockQuotationEntity ->stockQuotationMapper.map(stockQuotationEntity)).collect(Collectors.toList());
	}
}
