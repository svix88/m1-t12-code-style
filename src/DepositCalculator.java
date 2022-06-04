import java.util.Scanner;

public class DepositCalculator {
    double calculateComplexPercent(double amount, double yearRate, int depositPeriod) {
        double pay = amount * Math.pow((1 + yearRate / 12), 12 * depositPeriod);
        return round(pay);
    }

    double calculateSimplePercent(double amount, double yearRate, int depositPeriod) {
        return round(amount + amount * yearRate * depositPeriod);
    }

    double round(double value) {
        double scale = Math.pow(10, 2);
        return Math.round(value * scale) / scale;
    }

    void calculateContribution() {
        int period;
        int action;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях:");
        int amount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:");
        period = scanner.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = scanner.nextInt();
        double totalAmount = 0;
        double yearRate = 0.06;
        if (action == 1) {
            totalAmount = calculateSimplePercent(amount, yearRate, period);
        } else if (action == 2) {
            totalAmount = calculateComplexPercent(amount, yearRate, period);
        }
        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + totalAmount);
    }

    public static void main(String[] args) {
        new DepositCalculator().calculateContribution();
    }
}
