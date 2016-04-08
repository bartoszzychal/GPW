package pl.bartoszzychal.starterkit.app.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.bartoszzychal.starterkit.app.bank.model.entity.AccountEntity;


public interface AccountRepository extends JpaRepository<AccountEntity, Long> {

}
