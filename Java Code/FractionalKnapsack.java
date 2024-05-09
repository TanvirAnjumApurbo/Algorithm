import java.util.Arrays;

public class FractionalKnapsack {
  public static void main(String args[]) {

    int[] P = { 10, 5, 15, 7, 6, 18, 3 };
    int[] W = { 2, 3, 5, 7, 1, 4, 1 };
    int M = 15;

    double maxProfit = Knapsack(P, W, M);
    System.out.println("Maximum Profit: " + maxProfit);
  }

  public static double Knapsack(int[] P, int[] W, int M) {
    int n = P.length;
    double[] arr = new double[n];

    // Calculate value per unit weight
    for (int i = 0; i < n; i++) {
      arr[i] = (double) P[i] / W[i];
    }

    // Create an array of objects to store values and weights
    Item[] table = new Item[n];
    for (int i = 0; i < n; i++) {
      table[i] = new Item(P[i], W[i], arr[i]);
    }

    // Sort items based on value per unit weight
    Arrays.sort(table, (a, b) -> Double.compare(b.pwRatio, a.pwRatio));

    double currentMaxProfit = 0;
    int currentWeight = 0;

    // Iterate through items
    for (Item i : table) {
      if (currentWeight + i.weight <= M) {
        // Take the whole item
        currentMaxProfit += i.profit;
        currentWeight += i.weight;
      } else {
        // Take fraction of the item
        int remainingWeight = M - currentWeight;
        currentMaxProfit += i.pwRatio * remainingWeight;
        break;
      }
    }

    return currentMaxProfit;
  }

  // Item class to store profit, weight, and value per unit weight
  static class Item {
    int profit;
    int weight;
    double pwRatio;

    Item(int profit, int weight, double pwRatio) {
      this.profit = profit;
      this.weight = weight;
      this.pwRatio = pwRatio;
    }
  }
}
