public class Lagrange {
    public static void main(String[] args) {
        double[] x = {1, 2, 3, 4, 5};
        double[] y = {1, 8, 27, 64, 125};

        double interpolatedValue = lagrangeInterpolation(x, y, 2.5);
        
        System.out.println("Interpolated value at x = 2.5 is " + interpolatedValue);
        System.out.println("Values of x and y:");
        for (int i = 0; i < x.length; i++) {
            System.out.println("x[" + i + "] = " + x[i] + ", y[" + i + "] = " + y[i]);
        }
        
        System.out.println("\nProgrammed by: Ysac Advincula");
    }

    public static double lagrangeInterpolation(double[] x, double[] y, double point) {
        int n = x.length;
        double result = 0;

        for (int i = 0; i < n; i++) {
            double term = y[i];
            for (int j = 0; j < n; j++) {
                if (j != i) {
                    term = term * (point - x[j]) / (x[i] - x[j]);
                }
            }
            result += term;
        }

        return result;
    }
}
