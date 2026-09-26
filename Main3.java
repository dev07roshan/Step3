import java.util.*;

interface Room {
    double calculateBill(int units);
}

class SingleRoom implements Room {
    public double calculateBill(int units) {
        return units * 8;
    }
}

class SharedRoom implements Room {
    private int occupants;

    SharedRoom(int occupants) {
        this.occupants = occupants;
    }

    public double calculateBill(int units) {
        return (units * 6.0) / occupants;
    }
}

class ACRoom implements Room {
    public double calculateBill(int units) {
        return units * 10 + 200;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int units = sc.nextInt();

            Room room;

            switch (type) {
                case "SINGLE":
                    room = new SingleRoom();
                    break;

                case "SHARED":
                    int occupants = sc.nextInt();
                    room = new SharedRoom(occupants);
                    break;

                default:
                    room = new ACRoom();
            }

            double bill = room.calculateBill(units);
            total += bill;

            System.out.printf("%s: %.2f%n", type, bill);
        }

        System.out.printf("Total: %.2f%n", total);
    }
}
