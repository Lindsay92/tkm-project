package co.simplon.tkm.controllers;

import java.util.Collection;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.tkm.dtos.LikeView;
import co.simplon.tkm.services.LikeService;

@RestController
@RequestMapping("/likes")
public class LikeController {
	
	private final LikeService likeService;
    
    public LikeController(LikeService likeService) {
        this.likeService = likeService;
    }

    @PostMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void addActivityToUserFavorites(@PathVariable("id") Long activityId) {
        // Fetch the user id authenticated from the security context
        String userId = SecurityContextHolder.getContext().getAuthentication().getName();
        Long accountId = Long.valueOf(userId);

        likeService.like(activityId, accountId);
    }
    
    @DeleteMapping("/delete/{activityId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteActivityFromUserFavorites(@PathVariable("activityId") Long activityId) {
        String userId = SecurityContextHolder.getContext().getAuthentication().getName();
        Long accountId = Long.valueOf(userId);
        
        likeService.deleteByActivityIdAndAccountId(activityId, accountId);
    }
 
    @GetMapping("/user/all/favorite")
	public Collection<LikeView> getAll() {
    	return likeService.getAll();
    	
    }
    
}
