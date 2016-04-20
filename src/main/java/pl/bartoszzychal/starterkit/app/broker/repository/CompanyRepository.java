package pl.bartoszzychal.starterkit.app.broker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pl.bartoszzychal.starterkit.app.broker.model.entity.CompanyEntity;

public interface CompanyRepository extends JpaRepository<CompanyEntity, Long> {
	@Query("from CompanyEntity ce where ce.name = :name")
	CompanyEntity findOne(@Param("name") String name);
}
