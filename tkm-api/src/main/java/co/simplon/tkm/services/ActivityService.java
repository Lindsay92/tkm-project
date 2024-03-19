package co.simplon.tkm.services;

import java.util.Collection;
import java.util.Set;

import co.simplon.tkm.dtos.ActivityAdminView;
import co.simplon.tkm.dtos.ActivityCreateDto;
import co.simplon.tkm.dtos.ActivityDetailView;
import co.simplon.tkm.dtos.ActivityForUpdate;
import co.simplon.tkm.dtos.ActivityUpdateDto;
import co.simplon.tkm.dtos.ActivityView;
import co.simplon.tkm.entities.Activity;

public interface ActivityService {
	
	void create(ActivityCreateDto inputs);
	
	void update(Long id, ActivityUpdateDto inputs);
	
	void delete(Long id);
	
	Collection<ActivityView> getAll();

	ActivityForUpdate forUpdate(Long id);

	Collection<ActivityAdminView> getAllForEdit();

	ActivityDetailView detail(Long id);
	
//	Set<Activity> getFavorite(Long accountId);

	Set<Activity> getFavorite();

}
