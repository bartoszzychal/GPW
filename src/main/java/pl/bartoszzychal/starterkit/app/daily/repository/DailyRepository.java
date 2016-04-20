package pl.bartoszzychal.starterkit.app.daily.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.bartoszzychal.starterkit.app.daily.model.entity.DailyEntity;

@Repository
public interface DailyRepository extends JpaRepository<DailyEntity, Long> {
}
