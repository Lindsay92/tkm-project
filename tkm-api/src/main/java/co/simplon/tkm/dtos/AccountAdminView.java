package co.simplon.tkm.dtos;

import co.simplon.tkm.entities.Role;

public interface AccountAdminView {

	Long getId();
	
	String getFirstName();
	
	String getLastName();
	
	String getEmail();
	
	String getPassword();
	
	Role getRole();
	
}
