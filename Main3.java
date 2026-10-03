import java.util.*;

abstract class LibraryItem {
    String title;
    int daysLate;

    LibraryItem(String title, int daysLate) {
        this.title = title;
        this.daysLate = daysLate;
    }

    abstract double getFine();
}

class Book extends LibraryItem {

    Book(String title, int daysLate) {
        super(title, daysLate);
    }

    double getFine() {
        return daysLate * 2;
    }
}

class DVD extends LibraryItem {

    DVD(String title, int daysLate) {
        super(title, daysLate);
    }

    double getFine() {
        return Math.min(daysLate * 5, 50);
    }
}

class Magazine extends LibraryItem {

    Magazine(String title, int daysLate) {
        super(title, daysLate);
    }

    double getFine() {
        return daysLate;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String title = sc.next();
            int daysLate = sc.nextInt();

            LibraryItem item;

            if (type.equals("BOOK")) {
                item = new Book(title, daysLate);
            } 
            else if (type.equals("DVD")) {
                item = new DVD(title, daysLate);
            } 
            else {
                item = new Magazine(title, daysLate);
            }

            double fine = item.getFine();
            total += fine;

            System.out.printf("%s: %.2f%n", item.title, fine);
        }

        System.out.printf("Total Fines: %.2f%n", total);
    }
}
