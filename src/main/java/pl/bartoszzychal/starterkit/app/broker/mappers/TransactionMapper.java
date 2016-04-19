package pl.bartoszzychal.starterkit.app.broker.mappers;

import java.util.Collection;
import java.util.stream.Collectors;

import pl.bartoszzychal.starterkit.app.broker.model.entity.TransactionEntity;
import pl.bartoszzychal.starterkit.app.broker.model.to.TransactionTo;

public class TransactionMapper {
	public static TransactionTo map(TransactionEntity transactionEntity){
		return new TransactionTo(transactionEntity.getId(), 
				transactionEntity.getIdClient(), 
				StockMapper.map(transactionEntity.getStockEntity()), 
				transactionEntity.getDate(), 
				transactionEntity.getType(), 
				transactionEntity.getExecution());
	}
	
	public static TransactionEntity map(TransactionTo transactionTo){
		return new TransactionEntity(transactionTo.getIdClient(),
				StockMapper.map(transactionTo.getStockEntity()),
				transactionTo.getDate(),
				transactionTo.getType(),
				transactionTo.getExecution());
	}
	
	public static Collection<TransactionEntity> map2Entity(Collection<TransactionTo> transactionTos){
		return transactionTos.stream().map(TransactionMapper::map).collect(Collectors.toList());
	}
	public static Collection<TransactionTo> map2To(Collection<TransactionEntity> transactionEntities){
		return transactionEntities.stream().map(TransactionMapper::map).collect(Collectors.toList());
	}
}
