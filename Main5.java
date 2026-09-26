import java.util.*;
import java.time.LocalDate;

interface Plan {
    LocalDate calculateRenewalDate(LocalDate startDate);
}

class Basic implements Plan {
    public LocalDate calculateRenewalDate(LocalDate startDate) {
        return startDate.plusDays(30);
    }
}

class Standard implements Plan {
    public LocalDate calculateRenewalDate(LocalDate startDate) {
        return startDate.plusDays(90);
    }
}

class Premium implements Plan {
    public LocalDate calculateRenewalDate(LocalDate startDate) {
        return startDate.plusDays(365);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            String date = sc.next();

            LocalDate startDate = LocalDate.parse(date);

            Plan plan;

            switch (type) {
                case "BASIC":
                    plan = new Basic();
                    break;

                case "STANDARD":
                    plan = new Standard();
                    break;

                default:
                    plan = new Premium();
            }

            LocalDate renewalDate = plan.calculateRenewalDate(startDate);

            System.out.println(name + ": " + renewalDate);
        }
    }
}
