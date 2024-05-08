import java.util.Scanner;

import MathLogic.Divided;
import MathLogic.Backward;
import MathLogic.Forward;

public class Main {
    public static void main(String[] args) {
        Forward Forward = new Forward();
        Backward Backward = new Backward();
        Divided divided = new Divided();
        Scanner input = new Scanner(System.in);

        int n = 4;
        double y[][] = new double[10][10];
        double x[] = {12, 23, 34, 45};
        double sum = 0;
        double u = 0;

        y[0][0] = 123;
        y[1][0] = 456;
        y[2][0] = 789;
        y[3][0] = 1122;

        double value = 36;

        System.out.println("What do you want to do?");
        System.out.print("1. Newton's Forward Interpolation\n2. Newton's Backward Interpolation\n3. Newton's Divided Difference\nInput: ");
        int decision = input.nextInt();

        switch (decision) {
            case (1):
                Forward.calcForwardDiffTable(y, n);
                Forward.printForwardDiffTable(x, y, n);
                sum = y[0][0];
                u = (value - x[0]) / (x[1] - x[0]);

                for (int i = 1; i < n; i++) {
                    sum = sum + (Forward.p_cal(u, i) * y[0][i]) /
                            Forward.factorial(i);
                }
                sum = Math.round(sum * 10000.0) / 10000.0;
                System.out.println("\nValue using Newton's Forward Interpolation at x = " + value + " is " + sum);
                break;

            case (2):
                Backward.calcBackwardDiffTable(y, n);
                Backward.printForwardDiffTable(x, y, n);
                sum = y[n - 1][0];
                u = (value - x[n - 1]) / (x[1] - x[0]);
                for (int i = 1; i < n; i++) {
                    sum = sum + (Backward.p_cal(u, i) * y[n - 1][i]) /
                            Backward.factorial(i);
                }
                sum = Math.round(sum * 10000.0) / 10000.0;
                System.out.println("\nValue using Newton's Backward Interpolation at x = " + value + " is " + sum);
                break;
            case (3):
                divided.calcDD(x, y, n);
                divided.printDiffTable(x, y, n);
                sum = divided.applyFormula(value, x, y, n);
                sum = Math.round(sum * 10000.0) / 10000.0;
                System.out.println("\nValue using Newton's Divided Difference at x = " + value + " is " + sum);
                break;
            default:
                System.out.println("Invalid input");
        }
        input.close();
    }
}