public class AntiDifference {
    public static void main(String[] args) {
        for (int m = 0; m <= 20; m++) {
            System.out.println("m = " + m + ", Anti-difference of x^-" + m + " = " + antiDifference(m));
        }
        System.out.println("Programmed by: Ysac Advincula");
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
