import java.util.Scanner;

public class Sum {

    static void sumOfNaturalNumbers(int n) {
        int sum = 0;
        int i = 1;

        while (i <= n) {
            sum = sum + i;
            i++;
        }

        System.out.println("Sum of numbers from 1 to " + n + " = " + sum);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        sumOfNaturalNumbers(n);
    }
}