import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapsack {

    public static double getMaxProfit(int[] W, int[] P, int M, double[] quantities) {

        int n = W.length;
        double[] pwRatios = new double[n];

        for (int i = 0; i < n; i++) {
            pwRatios[i] = (double) P[i] / W[i];
        }

        Integer[] Items = new Integer[n];
        for (int i = 0; i < n; i++) {
            Items[i] = i;
        }

        Arrays.sort(Items, Comparator.comparingDouble(o -> -pwRatios[o]));

        double totalP = 0;

        for (int i : Items) {

            if (M > 0 && W[i] <= M) {
                quantities[i] = 1.0;
                totalP = totalP + P[i];
                M = M - W[i];

            } else if (M > 0) {
                quantities[i] = (double) M / W[i];
                totalP = totalP + pwRatios[i] * M;
                M = 0;

            } else {
                break;
            }
        }

        return totalP;
    }

    public static void main(String[] args) {

        int[] W = { 2, 3, 5, 7, 1, 4, 1 };
        int[] P = { 10, 5, 15, 7, 6, 18, 3 };
        int M = 15;

        double[] quantities = new double[W.length];

        double maxP = getMaxProfit(W, P, M, quantities);

        System.out.println("Maximum Profit: " + maxP);
        System.out.print("Quantities of items taken: [");

        for (int i = 0; i < quantities.length; i++) {

            System.out.printf("%.2f", quantities[i]);

            if (i < quantities.length - 1) {
                System.out.print("  ");
            }
        }
        System.out.println("]");
    }
}
