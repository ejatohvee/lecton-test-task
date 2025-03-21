package validation;

import validation.rules.ValidationRule;

import java.util.ArrayList;
import java.util.List;

public class DepositValidator {
    private final List<ValidationRule> rules;

    public DepositValidator(List<ValidationRule> rules) {
        this.rules = new ArrayList<>(rules);
    }

    public void addRule(ValidationRule rule) {
        rules.add(rule);
    }

    public void validate(double initialDeposit, double annualRate, double multiplier) {
        for (ValidationRule rule : rules) {
            rule.validate(initialDeposit, annualRate, multiplier);
        }
    }
}
