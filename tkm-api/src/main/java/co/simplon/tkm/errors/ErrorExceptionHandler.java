package co.simplon.tkm.errors;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ErrorExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(value = BadCredentialsException.class)
	protected ResponseEntity<Object> handleBadCredentialException(
			BadCredentialsException ex) {
		String body = ex.getMessage();
		return handleExceptionInternal(ex, body, 
				new HttpHeaders(), HttpStatus.UNAUTHORIZED, 
				null);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
	        MethodArgumentNotValidException ex,
	        HttpHeaders headers, HttpStatusCode status,
	        WebRequest request) {

	    List<String> errorMessages = new ArrayList<>();
	    for (FieldError error : ex.getBindingResult().getFieldErrors()) {
	    	errorMessages.add(error.getDefaultMessage());
	    }

	    CustomError customError = new CustomError(HttpStatus.BAD_REQUEST, 
	    		errorMessages);
	    return new ResponseEntity<>(customError, headers, 
	    		customError.getStatus());
	}
	
}
