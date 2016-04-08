package pl.bartoszzychal.starterkit.app.broker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.bartoszzychal.starterkit.app.broker.model.entity.StockQuotationEntity;

public interface StockQuotationRepository extends JpaRepository<StockQuotationEntity,Long> {

}
