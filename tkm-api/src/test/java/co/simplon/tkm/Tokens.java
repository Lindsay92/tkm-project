package co.simplon.tkm;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
class Tokens {

    @Value("${tkm.tests.valid-admin-token}")
    private String admin;

    @Value("${tkm.tests.valid-user-token}")
	private String user;

    String get(final String name) {
    	
	    switch (name) {
	        case "admin":
	        	return admin;
	        case "user":
	            return user;
	        default:
	        	throw new IllegalArgumentException("Unexpected value: " + name);
	    }
	  
    }

}
