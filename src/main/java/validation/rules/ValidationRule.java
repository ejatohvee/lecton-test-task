package validation.rules;

public interface ValidationRule {
    void validate(double initialDeposit, double annualRate, double multiplier) throws IllegalArgumentException;
}
