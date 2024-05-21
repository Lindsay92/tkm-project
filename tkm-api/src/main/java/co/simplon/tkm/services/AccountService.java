package co.simplon.tkm.services;

import java.util.Collection;

import co.simplon.tkm.dtos.AccountAdminView;
import co.simplon.tkm.dtos.Credentials;
import co.simplon.tkm.dtos.TokenInfo;

public interface AccountService {
	
	public void signUp(Credentials inputs);
	
	public void delete(Long id);

    public TokenInfo signIn(Credentials inputs);

	public Boolean existsByEmail(String email);

	public Collection<AccountAdminView> getAllAccounts();

}
