import java.util.Arrays;

public class FractionalKnapsack {
  public static void main(String args[]) {

    int[] P = { 5, 8, 6, 4, 10, 7 };
    int[] W = { 3, 6, 4, 2, 7, 5 };
    int M = 15;

    double maxProfit = Knapsack(P, W, M);
    System.out.println("Maximum Profit: " + maxProfit);
  }

  public static double Knapsack(int[] P, int[] W, int M) {
    int n = P.length;

    double[] arr = new double[n];
    // for (int i = 0; i < n; i++) {
    // arr[i] = (double) P[i] / W[i];
    // }

    Item[] table = new Item[n];
    for (int i = 0; i < n; i++) {
      table[i] = new Item(P[i], W[i], arr[i]);
    }

    Arrays.sort(table, (a, b) -> Double.compare(b.pwRatio, a.pwRatio));

    double currentMaxProfit = 0;
    int currentWeight = 0;

    for (Item i : table) {
      if (currentWeight + i.weight <= M) {

        currentMaxProfit += i.profit;
        currentWeight += i.weight;
      } else {

        int remainingWeight = M - currentWeight;
        currentMaxProfit += i.pwRatio * remainingWeight;
        break;
      }
    }

    return currentMaxProfit;
  }

  static class Item {
    int profit;
    int weight;
    double pwRatio;

    Item(int profit, int weight, double pwRatio) {
      this.profit = profit;
      this.weight = weight;
      this.pwRatio = (double) profit / weight;
    }
  }
}
