package co.simplon.tkm.repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import co.simplon.tkm.dtos.LikeActivityView;
import co.simplon.tkm.entities.Like;

public interface LikeActivityRepository extends JpaRepository<Like, Long>{

	LikeActivityView findProjectLikeById(Long id);

	Collection<LikeActivityView> findAllProjectedBy();

	

}
