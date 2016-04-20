package pl.bartoszzychal.starterkit.app.broker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.bartoszzychal.starterkit.app.broker.model.entity.BrokerEntity;

@Repository
public interface BrokerRepository extends JpaRepository<BrokerEntity, Long> {

}
