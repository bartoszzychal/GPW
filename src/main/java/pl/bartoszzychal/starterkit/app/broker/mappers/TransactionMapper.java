package pl.bartoszzychal.starterkit.app.broker.mappers;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import pl.bartoszzychal.starterkit.app.broker.mappers.IF.CompanyMapperIF;
import pl.bartoszzychal.starterkit.app.broker.mappers.IF.StockMapperIF;
import pl.bartoszzychal.starterkit.app.broker.mappers.IF.TransactionMapperIF;
import pl.bartoszzychal.starterkit.app.broker.model.entity.CompanyEntity;
import pl.bartoszzychal.starterkit.app.broker.model.entity.TransactionEntity;
import pl.bartoszzychal.starterkit.app.broker.model.enums.TransactionExecution;
import pl.bartoszzychal.starterkit.app.broker.model.enums.TransactionType;
import pl.bartoszzychal.starterkit.app.broker.model.to.CompanyTo;
import pl.bartoszzychal.starterkit.app.broker.model.to.TransactionTo;
import pl.bartoszzychal.starterkit.app.money.Money;

@Component
public class TransactionMapper implements TransactionMapperIF {
	
	@Autowired
    private ApplicationContext applicationContext;
	
	@PostConstruct
	private void init() {
		transactionMapper= applicationContext.getBean(TransactionMapper.class);
	}
	private TransactionMapperIF transactionMapper;
	
	@Autowired
	private CompanyMapperIF companyMapper;
	
	public  TransactionTo map(TransactionEntity transactionEntity){
		return new TransactionTo(transactionEntity.getId(),
				transactionEntity.getClientAccountNumber(),
				transactionEntity.getNumber(),
				companyMapper.map(transactionEntity.getCompany()),
				transactionEntity.getPrice(),
				transactionEntity.getDate(),
				transactionEntity.getType(),
				transactionEntity.getExecution());
	}
	
	public  TransactionEntity map(TransactionTo transactionTo){
		return new TransactionEntity(transactionTo.getId(),
				transactionTo.getClientAccountNumber(),
				transactionTo.getNumber(),
				companyMapper.map(transactionTo.getCompany()),
				transactionTo.getPrice(),
				transactionTo.getDate(),
				transactionTo.getType(),
				transactionTo.getExecution());
	}
	
	public  List<TransactionEntity> map2Entity(List<TransactionTo> transactionTos){
		return transactionTos.stream().map(t->transactionMapper.map(t)).collect(Collectors.toList());
	}
	public  List<TransactionTo> map2To(List<TransactionEntity> transactionEntities){
		return transactionEntities.stream().map(t->transactionMapper.map(t)).collect(Collectors.toList());
	}
}
