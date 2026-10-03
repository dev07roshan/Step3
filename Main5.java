import java.util.*;

abstract class TravelBooking {

    static final double BOOKING_FEE = 50;

    double distance;

    TravelBooking(double distance) {
        this.distance = distance;
    }

    abstract double getBaseFare();

    double getTotal() {
        return getBaseFare() + BOOKING_FEE;
    }
}

class Bus extends TravelBooking {

    Bus(double distance) {
        super(distance);
    }

    double getBaseFare() {
        return 2 * distance;
    }
}

class Train extends TravelBooking {

    Train(double distance) {
        super(distance);
    }

    double getBaseFare() {
        return 1.5 * distance;
    }
}

class Flight extends TravelBooking {

    Flight(double distance) {
        super(distance);
    }

    double getBaseFare() {
        return 2500 + 4 * distance;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String mode = sc.next();
            double distance = sc.nextDouble();

            TravelBooking booking;

            if (mode.equals("BUS")) {
                booking = new Bus(distance);
            } 
            else if (mode.equals("TRAIN")) {
                booking = new Train(distance);
            } 
            else {
                booking = new Flight(distance);
            }

            double fare = booking.getTotal();
            total += fare;

            System.out.printf("%s: %.2f%n", mode, fare);
        }

        System.out.printf("Total: %.2f%n", total);
    }
}
