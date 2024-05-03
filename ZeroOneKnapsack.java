public class ZeroOneKnapsack {

  public static void main(String[] args) {

    int[] weights = { 3, 2, 5, 4 };
    int[] values = { 4, 3, 6, 5 };

    int W = 5;
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
          dp[i][w] = Math.max(values[i - 1] + dp[i - 1][w - weights[i - 1]], dp[i - 1][w]);

        } else {
          dp[i][w] = dp[i - 1][w];
        }
      }
    }

    int i = n, w = W;
    System.out.print("Items Included: ");
    System.out.print("[ ");

    while (i > 0 && w > 0) {
      if (dp[i][w] != dp[i - 1][w]) {
        System.out.print("0 ");
        w = w - weights[i - 1];
      } else {
        System.out.print("1 ");
      }
      i--;
    }
    System.out.print("]");

    return dp[n][W];
  }
}
