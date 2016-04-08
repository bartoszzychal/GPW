package pl.bartoszzychal.starterkit.app.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.bartoszzychal.starterkit.app.bank.model.entity.CurrencyEntity;

public interface CurrencyRepository extends JpaRepository<CurrencyEntity, Long> {

}
