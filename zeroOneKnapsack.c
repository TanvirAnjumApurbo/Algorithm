#include <stdio.h>

int max(int a, int b)
{
  return (a > b) ? a : b;
}

int knapsack(int W, int weights[], int values[], int n)
{
  int dp[n + 1][W + 1];

  for (int i = 0; i <= n; i++)
  {
    for (int w = 0; w <= W; w++)
    {
      if (i == 0 || w == 0)
      {
        dp[i][w] = 0;
      }
      else if (weights[i - 1] <= w)
      {
        dp[i][w] = max(values[i - 1] + dp[i - 1][w - weights[i - 1]], dp[i - 1][w]);
      }
      else
      {
        dp[i][w] = dp[i - 1][w];
      }
    }
  }

  int i = n, w = W;
  printf("Items Included: ");
  while (i > 0 && w > 0)
  {
    if (dp[i][w] != dp[i - 1][w])
    {
      printf("0 ");
      w = w - weights[i - 1];
    }
    else
    {
      printf("1 ");
    }
    i--;
  }

  return dp[n][W];
}

int main()
{
  int weights[] = {3, 2, 5, 4};
  int values[] = {4, 3, 6, 5};
  int W = 5;
  int n = sizeof(values) / sizeof(values[0]);

  printf("\nMax Profit: %d\n", knapsack(W, weights, values, n));

  return 0;
}
