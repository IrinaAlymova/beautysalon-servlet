package controller.validator;

/**
 * Validator for sign up parameters
 */

public class SignUpValidator {
    private static final String EMAIL_VALIDATION_REGEXP = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";

    /**
     * Validate if the user input is a valid email
     */
    public boolean validateEmail(String email) {
        return email.matches(EMAIL_VALIDATION_REGEXP);
    }
}
