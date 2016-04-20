package pl.bartoszzychal.starterkit.app.bank.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pl.bartoszzychal.starterkit.app.bank.model.entity.CurrencyEntity;
import pl.bartoszzychal.starterkit.app.bank.model.enums.Currency;

public interface CurrencyRepository extends JpaRepository<CurrencyEntity, Long> {
	@Query("from CurrencyEntity c where c.date = :date and c.currency = :currency")
	CurrencyEntity getCurrencyFromDay(@Param("date") Date date,@Param("currency") Currency currency);
}
