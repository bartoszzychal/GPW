package pl.bartoszzychal.starterkit.app.broker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.bartoszzychal.starterkit.app.broker.model.entity.TransactionEntity;

public interface TransactionRepository extends JpaRepository<TransactionEntity, Long> {
	
}
