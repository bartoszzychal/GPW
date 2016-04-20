package pl.bartoszzychal.starterkit.app.broker.mappers;

import java.util.List;
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
				StockMapper.map(transactionTo.getStockTo()),
				transactionTo.getDate(),
				transactionTo.getType(),
				transactionTo.getExecution());
	}
	
	public static List<TransactionEntity> map2Entity(List<TransactionTo> transactionTos){
		return transactionTos.stream().map(TransactionMapper::map).collect(Collectors.toList());
	}
	public static List<TransactionTo> map2To(List<TransactionEntity> transactionEntities){
		return transactionEntities.stream().map(TransactionMapper::map).collect(Collectors.toList());
	}
}
