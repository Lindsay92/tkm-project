package co.simplon.tkm.controllers;

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.tkm.dtos.ActivityCreateDto;
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
	
	@GetMapping
	public Collection<ActivityView> getAll() {
		return service.getAll();
	}
}
