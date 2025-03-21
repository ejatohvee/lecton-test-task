import validation.*;
import validation.rules.AnnualRateNonNegativeRule;
import validation.rules.InitialDepositRule;
import validation.rules.MultiplierRule;
import validation.rules.ValidationRule;

import java.util.Arrays;
import java.util.List;

public class CalculationService {
    private final DepositValidator validator;
    public CalculationService() {
        List<ValidationRule> baseRules = Arrays.asList(new InitialDepositRule(), new AnnualRateNonNegativeRule(), new MultiplierRule());
        this.validator = new DepositValidator(baseRules);
    }

    public int calculateYears(double initialDeposit, double annualRate, double multiplier) {
        validator.validate(initialDeposit, annualRate, multiplier);

        double targetSum = initialDeposit * multiplier;
        double currentDeposit = initialDeposit;
        int years = 0;

        while (currentDeposit < targetSum) {
            currentDeposit += currentDeposit * (annualRate / 100.0);
            years++;
        }

        return years;
    }
}
