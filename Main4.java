import java.util.*;

abstract class Cab {
    protected double km;

    static final double MINIMUM_FARE = 100.0;

    Cab(double km) {
        this.km = km;
    }

    abstract double getRate();

    double getFare() {
        double fare = km * getRate();

        if (fare < MINIMUM_FARE) {
            fare = MINIMUM_FARE;
        }

        return fare;
    }
}

interface NightService {
    boolean hasNightService();
}

class Mini extends Cab {
    Mini(double km) {
        super(km);
    }

    double getRate() {
        return 10.0;
    }
}

class Sedan extends Cab implements NightService {
    Sedan(double km) {
        super(km);
    }

    double getRate() {
        return 14.0;
    }

    public boolean hasNightService() {
        return true;
    }
}

class SUV extends Cab implements NightService {
    SUV(double km) {
        super(km);
    }

    double getRate() {
        return 18.0;
    }

    public boolean hasNightService() {
        return true;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double km = sc.nextDouble();
            String time = sc.next();

            Cab cab;

            if (type.equals("MINI")) {
                cab = new Mini(km);
            } else if (type.equals("SEDAN")) {
                cab = new Sedan(km);
            } else {
                cab = new SUV(km);
            }

            if (time.equals("NIGHT") && !(cab instanceof NightService)) {
                System.out.println(type + ": night service not available");
                continue;
            }

            double fare = cab.getFare();

            if (time.equals("NIGHT")) {
                fare = fare * 1.20;
            }

            total += fare;

            System.out.printf("%s: %.2f%n", type, fare);
        }

        System.out.printf("Total: %.2f%n", total);
    }
}
