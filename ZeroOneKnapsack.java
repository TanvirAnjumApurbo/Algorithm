public class ZeroOneKnapsack {

  public static void main(String[] args) {

    int[] weights = { 2, 3, 4, 5 };
    int[] values = { 1, 2, 5, 6 };

    int W = 8;
    int n = weights.length;

    System.out.println("\nMax Profit: " + knapsack(W, weights, values, n));

  }

  public static int knapsack(int W, int[] weights, int[] values, int n) {

    int[][] dp = new int[n + 1][W + 1];

    for (int i = 0; i <= n; i++) {
      for (int w = 0; w <= W; w++) {

        if (i == 0 || w == 0) {
          dp[i][w] = 0;

        } else if (weights[i - 1] <= w) {
          dp[i][w] = Math.max(dp[i - 1][w - weights[i - 1]] + values[i - 1], dp[i - 1][w]);

        } else {
          dp[i][w] = dp[i - 1][w];
        }
      }
    }

    int[] includedItems = new int[n];
    int i = n, w = W;
    int count = 0;

    while (i > 0 && w > 0) {
      if (dp[i][w] != dp[i - 1][w]) {
        includedItems[count++] = 1;
        w = w - weights[i - 1];
      } else {
        includedItems[count++] = 0;
      }
      i--;
    }

    System.out.print("Items Included: [ ");
    for (int j = n - 1; j >= 0; j--) {
      System.out.print(includedItems[j] + " ");
    }
    System.out.print("]");

    return dp[n][W];
  }
}
