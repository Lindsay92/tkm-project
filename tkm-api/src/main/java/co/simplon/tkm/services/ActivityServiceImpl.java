package co.simplon.tkm.services;

import java.time.LocalDateTime;
import java.util.Collection;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import co.simplon.tkm.dtos.ActivityCreateDto;
import co.simplon.tkm.dtos.ActivityView;
import co.simplon.tkm.entities.Activity;
import co.simplon.tkm.repositories.ActivityRepository;

@Service
public class ActivityServiceImpl implements ActivityService {
	
	private ActivityRepository activities;
	
	public ActivityServiceImpl(ActivityRepository activities) {
		this.activities = activities;
	}
	
	@Override
	public void create(@Valid ActivityCreateDto inputs) {
		
		Activity activity = new Activity();
		
		activity.setName(inputs.getName());
		activity.setDescription(inputs.getDescription());
		activity.setImageUrl(inputs.getImageUrl());
		activity.setLocation(inputs.getLocation());
		activity.setLinkUrl(inputs.getLinkUrl());
		LocalDateTime createdAt = LocalDateTime.now();
		activity.setCreatedAt(createdAt);
		
		this.activities.save(activity);
		
	}
	
	@Override
	public Collection<ActivityView> getAll() {
		return activities.findAllProjectedBy();
	}
}
