package co.simplon.tkm.errors;

import java.util.List;

import org.springframework.http.HttpStatus;

public class CustomError {
	
	private HttpStatus status;
    private List<String> message;

    public CustomError(HttpStatus status, List<String> message) {
    	this.status = status;
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public List<String> getMessages() {
        return message;
    }
 
}

