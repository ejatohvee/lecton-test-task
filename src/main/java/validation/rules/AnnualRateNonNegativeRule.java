package validation.rules;

public class AnnualRateNonNegativeRule extends BaseValidationRule {
    private static final double MINIMAL_ANNUAL_RATE = 1e-1;

    public AnnualRateNonNegativeRule() {
        super("Процентная ставка должна быть больше " + MINIMAL_ANNUAL_RATE + " %");
    }

    @Override
    public void validate(double initialDeposit, double annualRate, double multiplier) {
        if (annualRate < MINIMAL_ANNUAL_RATE) throwError();
    }
}
