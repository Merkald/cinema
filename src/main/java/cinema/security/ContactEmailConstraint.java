package cinema.security;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = ContactEmailValidator.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface ContactEmailConstraint {
    String message() default "Invalid phone number";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
