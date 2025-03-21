package validation.rules;

public abstract class BaseValidationRule implements ValidationRule {
    protected final String errorMessage;

    public BaseValidationRule(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    protected void throwError() {
        throw new IllegalArgumentException(errorMessage);
    }
}
