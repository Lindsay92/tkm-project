package co.simplon.tkm.controllers;

import java.util.Collection;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import co.simplon.tkm.dtos.LikeActivityView;
import co.simplon.tkm.services.LikeActivityService;

@RestController
@RequestMapping("/likes")
public class LikeActivityController {
	
	private LikeActivityService service;
	
	public LikeActivityController(LikeActivityService service) {
		this.service = service;
}
	
	@GetMapping
	public Collection<LikeActivityView> getAll(){
		return service.getAll();
	}

	@GetMapping("/activity/{id}")
	public LikeActivityView saveFavorite(@PathVariable("id") Long id) {
		return service.saveFavorite(id);
	}

}
