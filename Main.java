import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Anti-Differencing Program!");
        System.out.println("Enter the value of m to calculate the anti-difference of x^-m:");
        int m = scanner.nextInt();
        System.out.println("Anti-difference of x^-" + m + " = " + antiDifference(m));
        System.out.println("Programmed by Ysac Advincula");
        scanner.close();
    }

    public static double antiDifference(int m) {
        if (m == 0) {
            // The anti-difference of x^0 is x
            return 1.0;
        } else {
            // The anti-difference of x^-m is -x^(1-m)/(1-m) for m != 1
            // and log(x) for m = 1
            return m == 1 ? 0.0 : -1.0 / (1 - m);
        }
    }
}
