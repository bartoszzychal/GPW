package pl.bartoszzychal.starterkit.app.broker.mappers.IF;

import java.util.List;

import pl.bartoszzychal.starterkit.app.broker.model.entity.TransactionEntity;
import pl.bartoszzychal.starterkit.app.broker.model.to.TransactionTo;

public interface TransactionMapperIF {

	TransactionTo map(TransactionEntity transactionEntity);

	TransactionEntity map(TransactionTo transactionTo);

	List<TransactionEntity> map2Entity(List<TransactionTo> transactionTos);

	List<TransactionTo> map2To(List<TransactionEntity> transactionEntities);

}
