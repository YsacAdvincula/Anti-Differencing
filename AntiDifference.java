public class AntiDifference {
    public static void main(String[] args) {
        printNeiTable(20);
    }

    static void printNeiTable(int n) {
        System.out.print("\nm\t\tIntegral\n---------------------------\n");
        for (int m = 0; m <= n; m++) {
            System.out.print(m + "\t\t");
            if (m == 1) {
                System.out.print("ln|x| + C\n");
            } else if (m == 0) {
                System.out.print("x\n");
            } else if (m > 2) {
                System.out.print("((x^" + (-m + 1) + ")/-" + Math.abs(-m + 1) + ") + C\n");
            } else if (m == 2) {
                System.out.print("-x^" + (-m + 1) + " + C\n");
            }
        }
    }
}
