package co.simplon.tkm;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
class Tokens {

//	@Value("${tkm.tests.fake-token}")
//    private String fake;
//
//    @Value("${tkm.tests.bad-secret-token}")
//    private String badSecret;
//
//    @Value("${tkm.tests.bad-issuer-token}")
//    private String badIssuer;
//
//    @Value("${tkm.tests.expired-token}")
//    private String expired;

    @Value("${tkm.tests.valid-admin-token}")
    private String admin;

    @Value("${tkm.tests.valid-user-token}")
	private String user;

    String get(final String name) {
    	
	    switch (name) {
//	        case "fake":
//	        	return fake;
//	        case "badSecret":
//	        	return badSecret;
//	        case "badIssuer":
//	        	return badIssuer;
//	        case "expired":
//	        	return expired;
	        case "admin":
	        	return admin;
	        case "user":
	            return user;
	        default:
	        	throw new IllegalArgumentException("Unexpected value: " + name);
	    }
	    
    }

}
