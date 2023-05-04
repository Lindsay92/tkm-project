package co.simplon.tkm.services;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;

import co.simplon.tkm.dtos.Credentials;
import co.simplon.tkm.dtos.TokenInfo;
import co.simplon.tkm.entities.Account;
import co.simplon.tkm.repositories.AuthRepository;
import co.simplon.tkm.utils.AuthHelper;

@Service
public class AuthServiceImpl implements AuthService {
	
	private final AuthHelper authHelper;
	private final AuthRepository authRepository;
	
	public AuthServiceImpl(AuthHelper authHelper, AuthRepository authRepository) {
		this.authHelper = authHelper;
		this.authRepository = authRepository;
		
	}
	
	// Implementation sign Up, sign in
    @Override
    public void signUp(Credentials inputs) {
    	Account account = new Account();
    	account.setEmail(inputs.getEmail());

    	String hashPassword = authHelper
		.encode(inputs.getPassword());
		account.setPassword(hashPassword);

	//List<String> roles = new ArrayList<String>();
	
//	if (inputs.getIdentifier()
//		.equalsIgnoreCase("admin")) {
//	    roles.add("ROLE_ADMIN");
//	} else if (inputs.getIdentifier()
//		.equalsIgnoreCase("both")) {
//	    roles.add("ROLE_ADMIN");
//	    roles.add("ROLE_USER");
//	} else {
//	    roles.add("ROLE_USER");
//	}
//	account.setRoles(roles);

	authRepository.save(account);
   }

    @Override
    public TokenInfo signIn(Credentials inputs) {
    	String identifier = inputs.getEmail();
    	String candidate = inputs.getPassword();
    	
    	Account account = authRepository.getByEmail(identifier);


	if (account != null) {
	    boolean match = authHelper.matches(candidate,
		    account.getPassword());
	    if (match) {
		String name = account.getEmail();
//		List<String> roles = account.getRoles();
//		String token = authHelper.createJWT(roles,
//			name);
		String token = authHelper.createJWT(null, name);

		TokenInfo tokenInfo = new TokenInfo();
		tokenInfo.setToken(token);
//		tokenInfo.setRoles(roles);

		return tokenInfo;
	    } else {
		throw new BadCredentialsException(
			"Wrong credentials");
	    }
	} else {
	    throw new BadCredentialsException(
		    "Wrong credentials");
	}
  }

}
