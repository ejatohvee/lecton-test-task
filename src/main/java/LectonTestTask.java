import java.util.Scanner;

public class LectonTestTask {
    private static String formatYears(int years) {
        int lastDigit = years % 10;
        int lastTwoDigits = years % 100;

        if (lastTwoDigits >= 11 && lastTwoDigits <= 14) return years + " лет";
        return switch (lastDigit) {
            case 1 -> years + " год";
            case 2, 3, 4 -> years + " года";
            default -> years + " лет";
        };
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Введите сумму вклада, процентную ставку и кратность увеличения:");

            CalculationService calculationService = new CalculationService();

            double deposit = scanner.nextDouble();
            double rate = scanner.nextDouble();
            double multiplier = scanner.nextDouble();

            int years = calculationService.calculateYears(deposit, rate, multiplier);
            System.out.printf("Вклад увеличится через %s.%n", formatYears(years));

        } catch (Exception e) {
            System.err.println("Ошибка ввода: " + e.getMessage());
        }
    }
}
