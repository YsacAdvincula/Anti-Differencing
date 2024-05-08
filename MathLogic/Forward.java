package MathLogic;
public class Forward {
    public double p_cal(double p, int n) {
        double p_product = p;
        for (int i = 1; i < n; i++)
            p_product = p_product * (p - i);
        return p_product;
    }

    public int factorial(int n) {
        int fact = 1;
        for (int i = 2; i <= n; i++)
            fact *= i;
        return fact;
    }

    public void calcForwardDiffTable(double y[][], int n) {
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n - i; j++)
                y[j][i] = y[j + 1][i - 1] - y[j][i - 1];
        }
    }

    public void printForwardDiffTable(double x[], double y[][], int n){
        System.out.println();
        for (int i = 0; i < n; i++) {
            System.out.print(x[i]+"\t");
            for (int j = 0; j < n - i; j++)
                System.out.print(y[i][j]+"\t");
            System.out.println();
        }
    }
}