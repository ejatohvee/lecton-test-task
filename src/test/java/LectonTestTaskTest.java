import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LectonTestTaskTest {
    private static final double MINIMAL_ANNUAL_RATE = 1e-1;

    @Test
    public void CalculateYears_NormalInput_Success() {
        CalculationService calculationService = new CalculationService();
        int years = calculationService.calculateYears(300.0, 10.0, 2.0);
        assertEquals(8, years);
    }

    @Test
    public void CalculateYears_MultiplierExactlyOne_Success() {
        CalculationService calculationService = new CalculationService();
        int years = calculationService.calculateYears(500.0, 10.0, 1.0);
        assertEquals(0, years);
    }

    @Test
    public void CalculateYears_ZeroDeposit_ThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            CalculationService calculationService = new CalculationService();
            calculationService.calculateYears(0.0, 10.0, 2.0);
        });
        assertEquals("Сумма вклада должна быть положительной", exception.getMessage());
    }

    @Test
    public void CalculateYears_NegativeRate_ThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            CalculationService calculationService = new CalculationService();
            calculationService.calculateYears(300.0, -5.0, 2.0);
        });
        assertEquals("Процентная ставка должна быть больше " + MINIMAL_ANNUAL_RATE + " %", exception.getMessage());
    }

    @Test
    public void CalculateYears_TinyGrowthPrecision_ThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            CalculationService calculationService = new CalculationService();
            calculationService.calculateYears(1000, 0.000001, 2.0);
        });
        assertEquals("Процентная ставка должна быть больше " + MINIMAL_ANNUAL_RATE + " %", exception.getMessage());
    }

    @Test
    public void CalculateYears_MultiplierLessThanOne_ThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            CalculationService calculationService = new CalculationService();
            calculationService.calculateYears(300.0, 10.0, 0.5);
        });
        assertEquals("Кратность должна быть >= 1", exception.getMessage());
    }
}
