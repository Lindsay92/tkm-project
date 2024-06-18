package co.simplon.tkm.customValidation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Documented
@Constraint(validatedBy = UniqueActivityNameValidator.class)
public @interface UniqueActivityName {
	String message() default "{tkm.validation.constraints.Unique.message}";

	Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
