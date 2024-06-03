import java.util.Arrays;

public class Treasure {
  public static void main(String args[]) {

    int[] values = { 5, 8, 6, 4, 10, 7 };
    int[] weights = { 3, 6, 4, 2, 7, 5 };
    char[] levels = { 'X', 'X', 'X', 'Y', 'X', 'X' };
    int capacity = 15;

    double maxProfit = knapsack(values, weights, levels, capacity);
    System.out.println("Maximum Profit: " + maxProfit);
  }

  public static double knapsack(int[] values, int[] weights, char[] levels, int capacity) {
    int n = values.length;

    Item[] table = new Item[n];
    for (int i = 0; i < n; i++) {
      table[i] = new Item(values[i], weights[i], levels[i]);
    }

    Arrays.sort(table, (a, b) -> Double.compare(b.pwRatio, a.pwRatio));

    double currentMaxProfit = 0;
    int currentWeight = 0;
    boolean collectedY = false;

    for (Item i : table) {

      if (i.level == 'Y') {
        if (currentWeight + i.weight <= capacity) {
          currentMaxProfit += i.value;
          currentWeight += i.weight;
          collectedY = true;
        } else {
          int remainingWeight = capacity - currentWeight;
          currentMaxProfit += i.pwRatio * remainingWeight;
          collectedY = true;
          break;
        }
      }
    }

    if (!collectedY) {
      System.out.println("At least one 'Y' level item must be collected. No valid solution.");
      return 0;
    }

    for (Item i : table) {

      if (currentWeight >= capacity)
        break;

      if (i.level != 'Y') {
        if (currentWeight + i.weight <= capacity) {
          currentMaxProfit += i.value;
          currentWeight += i.weight;
        } else {
          int remainingWeight = capacity - currentWeight;
          currentMaxProfit += i.pwRatio * remainingWeight;
          break;
        }
      }
    }

    return currentMaxProfit;
  }

  static class Item {
    int value;
    int weight;
    double pwRatio;
    char level;

    Item(int value, int weight, char level) {
      this.value = value;
      this.weight = weight;
      this.level = level;
      this.pwRatio = (double) value / weight;
    }
  }
}
