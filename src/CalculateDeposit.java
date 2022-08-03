import java.util.Scanner;

public class CalculateDeposit {
    public static void main(String[] args) {
        new CalculateDeposit().doImportantJob();
    }

    double calculateComplexPercent(double amount,
                                   double yearRate,
                                   int depositPeriod) {
        double pay = amount * Math.pow((1 + yearRate / 12), 12 * depositPeriod);
        return doRandom(pay, 2);
    }

    double calculateSimplePercent(double amount,
                                  double doubleYearRate,
                                  int depositPeriod) {
        return doRandom(amount + amount * doubleYearRate * depositPeriod, 2);
    }

    double doRandom(double value, int place) {
        double resultPow = Math.pow(10, place);
        return Math.round(value * resultPow) / resultPow;
    }

    void doImportantJob() {
        int period;
        int action;
        int amount;
        double total = 0;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите сумму вклада в рублях:");
        amount = scanner.nextInt();

        System.out.println("Введите срок вклада в годах:");
        period = scanner.nextInt();

        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = scanner.nextInt();

        if (action == 1) {
            total = calculateSimplePercent(amount, 0.06, period);
        } else if (action == 2) {
            total = calculateComplexPercent(amount, 0.06, period);
        }
        System.out.println("Результат вклада: " + amount
                + " за " + period + " лет превратятся в " + total);
    }
}
