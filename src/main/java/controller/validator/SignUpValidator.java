package controller.validator;

/**
 * Validator for sign up parameters
 */

public class SignUpValidator {
    private String EMAIL_VALIDATION_REGEXP = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";

    /**
     * Validate email input
     */
    public boolean validateEmail(String email) {
        return email.matches(EMAIL_VALIDATION_REGEXP);
    }
}
