package cinema.security;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ContactEmailValidator implements
        ConstraintValidator<ContactEmailConstraint, String> {

    @Override
    public void initialize(ContactEmailConstraint contactNumber) {
    }

    @Override
    public boolean isValid(String contactField,
                           ConstraintValidatorContext cxt) {
        return contactField != null && contactField.matches("[0-9]+")
                && (contactField.length() > 8) && (contactField.length() < 14);
    }

}
