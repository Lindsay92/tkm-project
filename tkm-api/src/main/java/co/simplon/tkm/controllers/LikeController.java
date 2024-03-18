package co.simplon.tkm.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

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
    public void addActivityToUserFavorites(@PathVariable("id") Long activity_id) {
        // Récupérez l'ID de l'utilisateur authentifié à partir du contexte de sécurité
        String userId = SecurityContextHolder.getContext().getAuthentication().getName();
        Long accountId = Long.valueOf(userId);

        // Appelez la méthode du service pour ajouter l'activité aux favoris de l'utilisateur
        likeService.like(activity_id, accountId);
    }


}
