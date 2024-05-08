package MathLogic;
import java.text.*;
import java.math.*;

public class Divided {

    public double xDiffs(int i, double value, double x[]) {
        float xDiff = 1;
        for (int j = 0; j < i; j++) {
            xDiff = (float) (xDiff * (value - x[j]));
        }
        return xDiff;
    }


    public void calcDD(double x[], double y[][], int n) {
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                y[j][i] = (y[j][i - 1] - y[j + 1]
                        [i - 1]) / (x[j] - x[i + j]);
            }
        }
    }

    public double applyFormula(double value, double x[],
                              double y[][], int n) {
         double sum = y[0][0];

        for (int i = 1; i < n; i++) {
            sum = sum + (xDiffs(i, value, x) * y[0][i]);
        }
        return sum;
    }

    public void printDiffTable(double x[], double y[][], int n) {
        DecimalFormat df = new DecimalFormat("#.####");
        df.setRoundingMode(RoundingMode.HALF_UP);

        for (int i = 0; i < n; i++) {
            String xval = df.format(x[i]);
            System.out.print(xval + "\t");
            for (int j = 0; j < n - i; j++) {
                String str1 = df.format(y[i][j]);
                System.out.print(str1 + "\t");
            }
            System.out.println();
        }
    }
}