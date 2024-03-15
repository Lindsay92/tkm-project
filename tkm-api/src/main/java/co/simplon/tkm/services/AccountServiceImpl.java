package co.simplon.tkm.services;

import java.util.Set;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import co.simplon.tkm.dtos.Credentials;
import co.simplon.tkm.dtos.TokenInfo;
import co.simplon.tkm.entities.Account;
import co.simplon.tkm.entities.Activity;
import co.simplon.tkm.entities.Role;
import co.simplon.tkm.repositories.AccountRepository;

import co.simplon.tkm.repositories.RoleRepository;
import co.simplon.tkm.utils.AccountHelper;

@Service
public class AccountServiceImpl implements AccountService {
	
	private final AccountHelper accountHelper;
	private final AccountRepository accountRepository;
	private final RoleRepository roleRepository;
	
	
	public AccountServiceImpl(AccountHelper accountHelper, 
			AccountRepository accountRepository, 
			RoleRepository roleRepository) {
		this.accountHelper = accountHelper;
		this.accountRepository = accountRepository;
		this.roleRepository = roleRepository;
		
	}
	
    @Override
    public void signUp(Credentials inputs) {
    	Account account = new Account();
    	account.setFirstName(inputs.getFirstName());
    	account.setLastName(inputs.getLastName());
    	account.setEmail(inputs.getEmail());

    	String hashPassword = accountHelper
		.encode(inputs.getPassword());
		account.setPassword(hashPassword);
		
//		Role role = roleRepository.getReferenceById(2L);
//		account.setRole(role);
		
		if (account.getEmail().endsWith("@tkm.com")) {
		    Role adminRole = roleRepository
			    .getReferenceByCodeRole("ROLE_ADMIN");
		    account.setRole(adminRole);
		} else {
		    Role role = roleRepository
			    .getReferenceByCodeRole("ROLE_USER");
		    account.setRole(role);
		}
		
		accountRepository.save(account);
   }
    
    @Override
    public TokenInfo signIn(Credentials inputs) {
    	String identifier = inputs.getEmail();
    	String candidate = inputs.getPassword();
    	
    	Account account = accountRepository.getByEmail(identifier);
    	
     	
	if (account != null) {
	    boolean match = accountHelper.matches(candidate,
		    account.getPassword());
	    if (match) {
			String name = account.getEmail();
	    	String id = account.getId().toString();
			String role = account.getRole().getRoleName();
			
			String token = accountHelper.createJWT(role, name);
//			String token = accountHelper.createJWT(role, id);
			
			
			TokenInfo tokenInfo = new TokenInfo();
			tokenInfo.setToken(token);
			tokenInfo.setRole(role);
			tokenInfo.setFirstName(account.getFirstName());
	
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
    @Override
    public Boolean existsByEmail(String email) {
    	return this.accountRepository
    			.existsByEmailIgnoreCase(email.toString());
    }
    
    
//	@Override
//	public Set<Account> getFavorite(Long activity_id){
//////		String context = SecurityContextHolder.getContext().getAuthentication().getName();
//////		Long userId = Long.valueOf(context);
//		return accountRepository.findActivitiesByfavoriteActivitiesId(activity_id);	
//	}
	

}
