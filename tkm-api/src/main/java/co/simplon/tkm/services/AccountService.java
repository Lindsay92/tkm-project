package co.simplon.tkm.services;

import co.simplon.tkm.dtos.Credentials;
import co.simplon.tkm.dtos.TokenInfo;
import co.simplon.tkm.entities.Activity;

public interface AccountService {
	
	public void signUp(Credentials inputs);

    public TokenInfo signIn(Credentials inputs);

	public Boolean existsByEmail(String email);
	
//	Activity getAccountById(Long id); 
    
}
