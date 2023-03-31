package co.simplon.tkm.services;

import java.util.Collection;

import co.simplon.tkm.dtos.ActivityCreateDto;
import co.simplon.tkm.dtos.ActivityView;

public interface ActivityService {
	
	void create(ActivityCreateDto inputs);
	
	Collection<ActivityView> getAll();

}
