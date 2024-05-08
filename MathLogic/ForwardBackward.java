package MathLogic;
public class ForwardBackward {
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

    public void calcBackwardDiffTable(double[][] y, int n) {
        for (int i = 1; i < n; i++) {
            for (int j = n - 1; j >= i; j--)
                y[j][i] = y[j][i - 1] - y[j - 1][i - 1];
        }
    }

    public void printForwardDiffTable(double x[], double y[][], int n){
        System.out.println();
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j <= i; j++)
                System.out.print(y[i][j] + "\t");
            System.out.println("");;
        }
    }
}