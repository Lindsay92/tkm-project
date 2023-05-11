package co.simplon.tkm.controllers;

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.tkm.dtos.ActivityAdminView;
import co.simplon.tkm.dtos.ActivityCreateDto;
import co.simplon.tkm.dtos.ActivityForUpdate;
import co.simplon.tkm.dtos.ActivityUpdateDto;
import co.simplon.tkm.dtos.ActivityView;
import co.simplon.tkm.services.ActivityService;

@RestController
@RequestMapping("/activities")
@CrossOrigin
public class ActivityController {
	
	private ActivityService service;
	
	public ActivityController(ActivityService service) {
		this.service = service;
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void create(@Valid @RequestBody ActivityCreateDto inputs) {
		service.create(inputs);
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void update(@PathVariable("id") Long id, @Valid @RequestBody ActivityUpdateDto inputs) {
		service.update(id, inputs);
	}
	
	@GetMapping
	public Collection<ActivityView> getAll() {
		return service.getAll();
	}
	
	@GetMapping("/{id}/for-update")
	public ActivityForUpdate forUpdate(@PathVariable("id") Long id) {
		return service.forUpdate(id);
	}
	
	@GetMapping("/for-edit")
	public Collection<ActivityAdminView> getAllForEdit() {
		return service.getAllForEdit();
	}
}
