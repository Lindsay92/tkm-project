package co.simplon.tkm.customValidation;

import co.simplon.tkm.services.ActivityService;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UniqueActivityNameValidator implements ConstraintValidator<UniqueActivityName, String> {

		final private ActivityService service;
		
		public UniqueActivityNameValidator(ActivityService service) {
			this.service = service;
		}
		
		@Override
		public boolean isValid(String name, ConstraintValidatorContext context) {
			if (name == null ) {
				return true;
			}
			return !this.service.existsByActivityName(name);
		}
}

