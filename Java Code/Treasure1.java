public class Treasure1 {

  public static void main(String[] args) {
    // Treasures: weights, values, levels
    int[] weights = { 3, 6, 4, 2, 7, 5 };
    int[] values = { 5, 8, 6, 4, 10, 7 };
    char[] levels = { 'X', 'X', 'X', 'Y', 'X', 'X' };

    int W = 15; 
    int n = weights.length;

    int requiredWeight = weights[3];
    int requiredValue = values[3];

    W -= requiredWeight;
    int[] remainingWeights = new int[n - 1];
    int[] remainingValues = new int[n - 1];

    for (int i = 0, j = 0; i < n; i++) {
      if (i != 3) { 
        remainingWeights[j] = weights[i];
        remainingValues[j] = values[i];
        j++;
      }
    }

    int maxProfit = requiredValue + knapsack(W, remainingWeights, remainingValues);

    System.out.println("Max Profit: " + maxProfit);
  }

  public static int knapsack(int W, int[] weights, int[] values) {
    int n = weights.length;
    int[][] dp = new int[n + 1][W + 1];

    for (int i = 1; i <= n; i++) {
      for (int w = 1; w <= W; w++) {
        if (weights[i - 1] <= w) {
          dp[i][w] = Math.max(dp[i - 1][w - weights[i - 1]] + values[i - 1], dp[i - 1][w]);
        } else {
          dp[i][w] = dp[i - 1][w];
        }
      }
    }

    return dp[n][W];
  }
}
