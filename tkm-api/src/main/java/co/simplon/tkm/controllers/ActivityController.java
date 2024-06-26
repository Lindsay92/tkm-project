package co.simplon.tkm.controllers;

import java.util.Collection;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.tkm.dtos.ActivityAdminView;
import co.simplon.tkm.dtos.ActivityCreateDto;
import co.simplon.tkm.dtos.ActivityDetailView;
import co.simplon.tkm.dtos.ActivityForUpdate;
import co.simplon.tkm.dtos.ActivityUpdateDto;
import co.simplon.tkm.dtos.ActivityView;
import co.simplon.tkm.services.ActivityService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/activities")
public class ActivityController {
	
	private ActivityService service;
	
	public ActivityController(ActivityService service) {
		this.service = service;
	}
	
	//FOR ADMIN
	@PostMapping
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void create(@ModelAttribute @Valid ActivityCreateDto inputs) {
		service.create(inputs);
	}
	
	@PutMapping("/{id}/for-change")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void update(@PathVariable("id") Long id, @ModelAttribute @Valid ActivityUpdateDto inputs) {
		service.update(id, inputs);
	}
	
	@DeleteMapping("/{id}/for-delete")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") Long id) {
		service.delete(id);
	}
	
	@GetMapping("/{id}/for-update")
	public ActivityForUpdate forUpdate(@PathVariable("id") Long id) {
		return service.forUpdate(id);
	}
	
	@GetMapping("/for-edit")
	public Collection<ActivityAdminView> getAllForEdit() {
		return service.getAllForEdit();
	}
	
	//FOR USER
	@GetMapping()
	public Collection<ActivityView> getAll() {
		return service.getAll();
	}
	
	@GetMapping("/{id}/detail")
	public ActivityDetailView detail(@PathVariable("id") Long id) {
		return service.detail(id);
	}
		
}
