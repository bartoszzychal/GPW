package pl.bartoszzychal.starterkit.app.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pl.bartoszzychal.starterkit.app.bank.model.entity.AccountEntity;

@Repository
public interface AccountRepository extends JpaRepository<AccountEntity, Long> {

	@Query("from AccountEntity a where a.accountNumber = :accountNumber")
	AccountEntity getAccountByNumber(@Param("accountNumber") Long accountNumber);
}
