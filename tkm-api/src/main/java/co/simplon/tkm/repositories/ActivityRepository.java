
package co.simplon.tkm.repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import co.simplon.tkm.dtos.ActivityAdminView;
import co.simplon.tkm.dtos.ActivityDetailView;
import co.simplon.tkm.dtos.ActivityForUpdate;
import co.simplon.tkm.dtos.ActivityView;
import co.simplon.tkm.entities.Activity;

public interface ActivityRepository extends JpaRepository<Activity, Long> {
	
	Collection<ActivityView> findAllProjectedBy();
	
	ActivityForUpdate findProjectedById(Long id);

	Collection<ActivityAdminView> findAllProjectedByOrderByCreatedAtDescName();

	ActivityDetailView findProjectedDetailById(Long id);

}
