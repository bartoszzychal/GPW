package pl.bartoszzychal.starterkit.app.broker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.bartoszzychal.starterkit.app.broker.model.entity.StockEntity;

public interface StockRepository extends JpaRepository<StockEntity, Long> {

}
