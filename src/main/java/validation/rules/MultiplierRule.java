package validation.rules;


public class MultiplierRule extends BaseValidationRule {
    public MultiplierRule() {
        super("Кратность должна быть >= 1");
    }

    @Override
    public void validate(double initialDeposit, double annualRate, double multiplier) {
        if (multiplier < 1) throwError();
    }
}
