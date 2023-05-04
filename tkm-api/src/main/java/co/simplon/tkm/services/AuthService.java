package co.simplon.tkm.services;

import co.simplon.tkm.dtos.Credentials;
import co.simplon.tkm.dtos.TokenInfo;

public interface AuthService {
	
	public void signUp(Credentials inputs);

    public TokenInfo signIn(Credentials inputs);

}
