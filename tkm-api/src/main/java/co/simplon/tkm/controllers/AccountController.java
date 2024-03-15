package co.simplon.tkm.controllers;


import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;


import co.simplon.tkm.dtos.Credentials;
import co.simplon.tkm.dtos.TokenInfo;
import co.simplon.tkm.entities.Account;
import co.simplon.tkm.entities.Activity;
import co.simplon.tkm.services.AccountService;

@RestController
public class AccountController {
	
	@Autowired
    private AccountService service;

    @PostMapping("/sign-up")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void signUp(@RequestBody Credentials inputs) {
    	service.signUp(inputs);
    }

    @PostMapping("/sign-in")
    public TokenInfo signIn(@RequestBody Credentials inputs) {
    	return service.signIn(inputs);
    }
    
//    @GetMapping("/activities/{id}/favorite")
//	public Set<Account> favorite(@PathVariable("id") Long activity_id) {
//		return service.getFavorite(activity_id);
//	}

}

