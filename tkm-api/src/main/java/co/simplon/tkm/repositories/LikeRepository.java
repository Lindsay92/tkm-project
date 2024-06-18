package co.simplon.tkm.repositories;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import co.simplon.tkm.dtos.LikeView;
import co.simplon.tkm.entities.Like;

public interface LikeRepository extends JpaRepository<Like, Long> {

	@Modifying
	@Query("DELETE FROM Like l WHERE l.activity.id = :activityId AND l.account.id = :accountId")
	void deleteByActivityIdAndAccountId(@Param("activityId") Long activityId, @Param("accountId") Long accountId);

	Set<LikeView> findByAccountId(@Param("accountId") Long accountId);
}
