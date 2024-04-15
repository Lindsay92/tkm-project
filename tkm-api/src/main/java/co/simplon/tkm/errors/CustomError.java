package co.simplon.tkm.errors;

import java.util.List;

import org.springframework.http.HttpStatus;

public class CustomError {
	
	private HttpStatus status;
    private List<String> messages;

    public CustomError(HttpStatus status, List<String> messages) {
    	this.status = status;
        this.messages = messages;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public List<String> getMessages() {
        return messages;
    }
 
}

