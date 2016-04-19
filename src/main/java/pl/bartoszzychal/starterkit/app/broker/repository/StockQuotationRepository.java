package pl.bartoszzychal.starterkit.app.broker.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pl.bartoszzychal.starterkit.app.broker.model.entity.StockQuotationEntity;

public interface StockQuotationRepository extends JpaRepository<StockQuotationEntity,Long> {
	@Query("from StockQuotationEntity ste where DATEDIFF(ste.date,:date) = 0")
	List<StockQuotationEntity> getTodayStockQuotation(@Param("date") Date date);
	@Query("from StockQuotationEntity ste where ste.date between :lowerdate and :upperdate")
	List<StockQuotationEntity> getStockQuotationFrom(@Param("lowerdate") Date lowerdate,@Param("upperdate") Date upperdate);
}
