package co.simplon.tkm.services;

import java.time.LocalDateTime;
import java.util.Collection;

import javax.validation.Valid;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.simplon.tkm.dtos.ActivityAdminView;
import co.simplon.tkm.dtos.ActivityCreateDto;
import co.simplon.tkm.dtos.ActivityDetailView;
import co.simplon.tkm.dtos.ActivityForUpdate;
import co.simplon.tkm.dtos.ActivityUpdateDto;
import co.simplon.tkm.dtos.ActivityView;
import co.simplon.tkm.entities.Activity;
import co.simplon.tkm.repositories.ActivityRepository;

@Service
@Transactional(readOnly = true) //toutes mes classes sont en lecture par défaut
public class ActivityServiceImpl implements ActivityService {
	
	private ActivityRepository activities;
	
	public ActivityServiceImpl(ActivityRepository activities) {
		this.activities = activities;
	}
	
	@Override
	@Transactional //mean "read only" = false
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
	@Transactional
	public void update(Long id, ActivityUpdateDto inputs) {
		
		Activity activity = activities.findById(id).get();
		
		activity.setName(inputs.getName());
		activity.setDescription(inputs.getDescription());
		activity.setImageUrl(inputs.getImageUrl());
		activity.setLocation(inputs.getLocation());
		activity.setLinkUrl(inputs.getLinkUrl());
		LocalDateTime createdAt = LocalDateTime.now();
		activity.setCreatedAt(createdAt);
		
		activities.save(activity);
	}
	
	@Override
	public ActivityForUpdate forUpdate(Long id ) {
		return activities.findProjectedById(id);
	}
	
	@Override
	public Collection<ActivityView> getAll() {
		return activities.findAllProjectedBy();
	}
	
	@Override
	public Collection<ActivityAdminView> getAllForEdit() {
		return activities.findAllProjectedByOrderByCreatedAtDescName();
	}
	
	@Override
    public ActivityDetailView detail(Long id) {
	return activities.findProjectedDetailById(id);
    }
}
