import java.util.Arrays;
import java.util.Scanner;

public class FractionalKnapsackWithPrint_Scan {
  public static void main(String args[]) {
    Scanner input = new Scanner(System.in);

    System.out.print("Enter the number of items: ");
    int n = input.nextInt();

    int[] W = new int[n];
    int[] P = new int[n];

    System.out.println("Enter weights and profits for each item:");
    for (int i = 0; i < n; i++) {
      W[i] = input.nextInt();
      P[i] = input.nextInt();
    }

    System.out.print("Enter the capacity of the knapsack: ");
    int M = input.nextInt();

    double maxProfit = Knapsack(P, W, M);
    System.out.println("Maximum Profit: " + maxProfit);

    input.close();
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
      table[i] = new Item(P[i], W[i], arr[i], i); // Store index of the item
    }

    // Sort items based on value per unit weight
    Arrays.sort(table, (a, b) -> Double.compare(b.pwRatio, a.pwRatio));

    double currentMaxProfit = 0;
    double currentWeight = 0;

    // Initialize an array to store the count of each item taken
    double[] counts = new double[n];

    // Iterate through items
    for (Item i : table) {
      if (currentWeight + i.weight <= M) {
        // Take the whole item
        currentMaxProfit += i.profit;
        counts[i.index] = 1; // Take the whole item
        currentWeight += i.weight;
      } else {
        // Take fraction of the item
        double fraction = (M - currentWeight) / (double) i.weight;
        currentMaxProfit += i.pwRatio * (M - currentWeight);
        counts[i.index] = fraction; // Take fraction of the item
        break;
      }
    }

    // Print the counts
    for (double count : counts) {
      System.out.print(count + "    ");
    }
    System.out.println();

    return currentMaxProfit;
  }

  // Item class to store profit, weight, and value per unit weight
  static class Item {
    int profit;
    int weight;
    double pwRatio;
    int index; // Index of the item in the original arrays

    Item(int profit, int weight, double pwRatio, int index) {
      this.profit = profit;
      this.weight = weight;
      this.pwRatio = pwRatio;
      this.index = index;
    }
  }
}
