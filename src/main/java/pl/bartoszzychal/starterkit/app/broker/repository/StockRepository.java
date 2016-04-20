package pl.bartoszzychal.starterkit.app.broker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pl.bartoszzychal.starterkit.app.broker.model.entity.StockEntity;

public interface StockRepository extends JpaRepository<StockEntity, Long> {
	@Query("from StockEntity se where se.clientAccountNumber = :clientAccountNumber")
	List<StockEntity> getClientStocks(@Param("clientAccountNumber")Long clientAccountNumber);
}
