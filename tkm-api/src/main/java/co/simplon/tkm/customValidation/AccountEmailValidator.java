package co.simplon.tkm.customValidation;

import org.springframework.security.authentication.BadCredentialsException;
import co.simplon.tkm.services.AccountService;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class AccountEmailValidator implements ConstraintValidator<AccountEmail, String> {
	
	final private AccountService service;
	
	public AccountEmailValidator(AccountService service) {
		this.service = service;
	}
	
	@Override
	public boolean isValid(String email, ConstraintValidatorContext context) {
		if ((email != null) && this.service.existsByEmail(email)) {
			throw new BadCredentialsException(
					
					"This email is already used"
			);
		}
		return true;
	}
}
