package pl.bartoszzychal.starterkit.app.daily.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pl.bartoszzychal.starterkit.app.daily.model.entity.DailyEntity;

@Repository
public interface DailyRepository extends JpaRepository<DailyEntity, Long> {
	@Modifying
	@Query("update daily de set de.currentDay =:date where de.id = 1")
	void nextDay(@Param("date") Date date);
}
