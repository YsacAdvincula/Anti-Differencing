import java.util.Arrays;

public class NewtonFiniteDifference {
    public static void main(String[] args) {
        double[] x = {1, 2, 4, 6, 8}; // New sample points
        double[] y = {2, 3, 5, 7, 11}; // New corresponding function values
        
        // Display all values of x and y alongside final value
        System.out.println("Data points:");
        for (int i = 0; i < x.length; i++) {
            System.out.println("x[" + i + "]: " + x[i] + ", y[" + i + "]: " + y[i]);
        }
        
        // Calculate and display forward difference
        System.out.println("\nForward Difference: " + forwardDifference(y));
        
        // Calculate and display backward difference
        System.out.println("Backward Difference: " + backwardDifference(y));
        
        // Calculate and display central difference
        System.out.println("Central Difference: " + centralDifference(y));
        
        // Calculate and display Newton's finite difference
        System.out.println("Newton's Finite Difference: " + newtonFiniteDifference(x, y));
        
        // Display programmer's name
        System.out.println("\nProgrammer: Ysac Advincula");
    }
    
    public static double forwardDifference(double[] y) {
        int n = y.length;
        double[] delta = new double[n - 1];
        for (int i = 0; i < n - 1; i++) {
            delta[i] = y[i + 1] - y[i];
        }
        return delta[0]; // Return first forward difference
    }
    
    public static double backwardDifference(double[] y) {
        int n = y.length;
        double[] delta = new double[n - 1];
        for (int i = n - 1; i > 0; i--) {
            delta[i - 1] = y[i] - y[i - 1];
        }
        return delta[n - 2]; // Return first backward difference
    }
    
    public static double centralDifference(double[] y) {
        int n = y.length;
        if (n < 3) {
            return 0; // Central difference requires at least 3 points
        }
        return (y[2] - y[0]) / 2.0; // Return first central difference
    }
    
    public static double newtonFiniteDifference(double[] x, double[] y) {
        int n = x.length;
        double[][] dividedDifferenceTable = new double[n][n];
        
        // Initialize the divided difference table with function values
        for (int i = 0; i < n; i++) {
            dividedDifferenceTable[i][0] = y[i];
        }
        
        // Construct the divided difference table
        for (int j = 1; j < n; j++) {
            for (int i = 0; i < n - j; i++) {
                dividedDifferenceTable[i][j] = (dividedDifferenceTable[i + 1][j - 1] - dividedDifferenceTable[i][j - 1]) / (x[i + j] - x[i]);
            }
        }
        
        // Return the first element of the first row, which represents the Newton finite difference
        return dividedDifferenceTable[0][0];
    }
}
