package validation.rules;


public class InitialDepositRule extends BaseValidationRule {
    public InitialDepositRule() {
        super("Сумма вклада должна быть положительной");
    }

    @Override
    public void validate(double initialDeposit, double annualRate, double multiplier) {
        if (initialDeposit <= 0) throwError();
    }
}
