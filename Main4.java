import java.util.*;

interface Employee {
    double calculateBonus(double salary);
}

class FullTime implements Employee {
    public double calculateBonus(double salary) {
        return salary * 0.10;
    }
}

class PartTime implements Employee {
    public double calculateBonus(double salary) {
        return salary * 0.05;
    }
}

class Intern implements Employee {
    public double calculateBonus(double salary) {
        return 2000;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            double salary = sc.nextDouble();

            Employee employee;

            switch (type) {
                case "FULLTIME":
                    employee = new FullTime();
                    break;

                case "PARTTIME":
                    employee = new PartTime();
                    break;

                default:
                    employee = new Intern();
            }

            double bonus = employee.calculateBonus(salary);
            total += bonus;

            System.out.printf("%s: %.2f%n", name, bonus);
        }

        System.out.printf("Total Bonus: %.2f%n", total);
    }
}
