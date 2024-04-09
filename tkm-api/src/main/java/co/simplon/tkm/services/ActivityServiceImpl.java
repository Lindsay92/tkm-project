package co.simplon.tkm.services;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import co.simplon.tkm.dtos.ActivityAdminView;
import co.simplon.tkm.dtos.ActivityCreateDto;
import co.simplon.tkm.dtos.ActivityDetailView;
import co.simplon.tkm.dtos.ActivityForUpdate;
import co.simplon.tkm.dtos.ActivityUpdateDto;
import co.simplon.tkm.dtos.ActivityView;
import co.simplon.tkm.entities.Activity;
import co.simplon.tkm.repositories.AccountRepository;
import co.simplon.tkm.repositories.ActivityRepository;

@Service
@Transactional(readOnly = true) //toutes mes classes sont en lecture par défaut
public class ActivityServiceImpl implements ActivityService {
	
	private ActivityRepository activities;
	
	@Value("${tkm.api.uploads.location}")
    private String uploadDir;
	
	public ActivityServiceImpl(ActivityRepository activities) {
		this.activities = activities;
	}
	
	@Override
	@Transactional 
	public void create(ActivityCreateDto inputs) {
		
		Activity activity = new Activity();
		
		activity.setName(inputs.getName());
		activity.setDescription(inputs.getDescription());
		MultipartFile image = inputs.getImageUrl();
		String baseName = UUID.randomUUID().toString();
	    String fileName = baseName
		    + inputs.getImageUrl().getOriginalFilename();
	    store(image, fileName);
		activity.setImageUrl(fileName);
		activity.setLocation(inputs.getLocation());
		activity.setLinkUrl(inputs.getLinkUrl());
		LocalDateTime createdAt = LocalDateTime.now();
		activity.setCreatedAt(createdAt);
		
		activities.save(activity);
		
	}
	
	@Override
	@Transactional
	public void update(Long id, ActivityUpdateDto inputs) {
		
		Activity activity = activities.findById(id).get();
		
		activity.setName(inputs.getName());
		activity.setDescription(inputs.getDescription());
		
		if((inputs.getImageUrl() != null)) {
			Path oldImage = Paths.get(uploadDir, activity.getImageUrl());
			MultipartFile image = inputs.getImageUrl();
		    String baseName = UUID.randomUUID().toString();
		    String fileName = baseName
			    + inputs.getImageUrl().getOriginalFilename();
		    activity.setImageUrl(fileName);
		    store(image, fileName);
		    oldImage.toFile().delete();
		}
//		activity.setImageUrl(inputs.getImageUrl());
		
		activity.setLocation(inputs.getLocation());
		activity.setLinkUrl(inputs.getLinkUrl());
		LocalDateTime createdAt = LocalDateTime.now();
		activity.setCreatedAt(createdAt);
		
		activities.save(activity);
	}
	
	private void store(MultipartFile image, String fileName) {
		Path uploadPath = Paths.get(uploadDir);
		Path target = uploadPath.resolve(fileName);
		try (InputStream in = image.getInputStream()) {
			Files.copy(in, target, StandardCopyOption.REPLACE_EXISTING);	
		} catch (IOException ex) {
			throw new RuntimeException(ex);
		}
		
	}
	
	@Override
	public ActivityForUpdate forUpdate(Long id ) {
		return activities.findProjectedById(id);
	}
	
	@Override
	@Transactional
	public void delete(Long id) {
		activities.deleteById(id);
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
	
	@Override
	public Set<Activity> getFavorite(){
		String context = SecurityContextHolder.getContext().getAuthentication().getName();
		Long userId = Long.valueOf(context); // parseLong
//		return activities.findActivitiesByLikedByAccountId(account_id);
		System.out.println(userId);
		System.out.println("lindsay");
		return activities.findActivitiesByLikedByAccountId(userId);
	}
	
	@Override
	public Boolean existsByActivityName(String name) {
		return this.activities
			.existsByName(name);
	}
	
}
