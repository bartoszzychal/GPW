package pl.bartoszzychal.starterkit.app.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.bartoszzychal.starterkit.app.bank.model.entity.FundsEntity;

public interface FundsRepository extends JpaRepository<FundsEntity,Long> {

}
