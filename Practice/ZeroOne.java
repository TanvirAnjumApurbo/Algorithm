
import java.util.Scanner;

public class ZeroOne {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    System.out.println("Enter the number of items: ");
    int n = input.nextInt();

    int weights[] = new int[n];
    int values[] = new int[n];

    System.out.println("Enter the weights & values of the items: ");
    for (int i = 0; i < n; i++) {
      weights[i] = input.nextInt();
      values[i] = input.nextInt();
    }

    System.out.println("Enter the capacity of the knapsack: ");
    int W = input.nextInt();

    System.out.println("List of products" + knapsack(W, weights, values, n));

  }

  public static int knapsack(int W, int weights[], int values[], int n) {

    int dp[][] = new int[n + 1][W + 1];

    for (int i = 0; i <= n; i++) {
      for (int w = 0; w <= W; w++) {
        if (i == 0 || w == 0) {
          dp[i][w] = 0;
        } else if (weights[i - 1] <= w) {
          dp[i][w] = Math.max(dp[i - 1][w - weights[i - 1]] + values[i - 1], dp[i - 1][w]);
        } else
          dp[i][w] = dp[i - 1][w];
      }
    }

    int includedItems[] = new int[n];
    int i = n, w = W;

    while (i > 0 && w > 0) {

      if (dp[i][w] != dp[i - 1][w]) {
        includedItems[i - 1] = 1;
        w = w - weights[i - 1];
      } else {
        includedItems[i - 1] = 0;
      }
      i--;
    }
    for (int j = 0; j < n; j++) {
      System.out.print(includedItems[j] + " ");
    }
    return dp[n][w];
  }
}
