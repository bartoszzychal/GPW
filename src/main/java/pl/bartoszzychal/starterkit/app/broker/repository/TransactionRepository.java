package pl.bartoszzychal.starterkit.app.broker.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pl.bartoszzychal.starterkit.app.broker.model.entity.TransactionEntity;

public interface TransactionRepository extends JpaRepository<TransactionEntity, Long> {
	@Query("from TransactionEntity te where DATEDIFF(te.date,:date) = 0 and te.idClient = :idClient")
	List<TransactionEntity> getTodayTransactions(@Param("date") Date date,@Param("idClient") Long idClient);
}
