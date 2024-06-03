#include <stdio.h>

int max(int a, int b) { return (a > b) ? a : b; }

void knapsack(int W, int weights[], int values[], int n)
{
  int i, w;
  int dp[n + 1][W + 1];
  int includedItems[n];

  // Initialize includedItems array to 0
  for (i = 0; i < n; i++)
  {
    includedItems[i] = 0;
  }

  for (i = 0; i <= n; i++)
  {
    for (w = 0; w <= W; w++)
    {
      if (i == 0 || w == 0)
        dp[i][w] = 0;
      else if (weights[i - 1] <= w)
        dp[i][w] = max(values[i - 1] + dp[i - 1][w - weights[i - 1]], dp[i - 1][w]);
      else
        dp[i][w] = dp[i - 1][w];
    }
  }

  int count = 0;
  i = n, w = W;
  while (i > 0 && w > 0)
  {
    if (dp[i][w] != dp[i - 1][w])
    {
      includedItems[count++] = 1;
      w = w - weights[i - 1];
    }
    else
    {
      includedItems[count++] = 0;
    }
    i--;
  }

  printf("Items Included: [ ");
  for (int j = n - 1; j >= 0; j--)
  {
    printf("%d ", includedItems[j]);
  }
  printf("]\n");

  printf("Max Profit: %d\n", dp[n][W]);
}

int main()
{
  int n;
  printf("Enter the number of items: ");
  scanf("%d", &n);

  int weights[n];
  int values[n];

  printf("Enter the weights and values for each item:\n");
  for (int i = 0; i < n; i++)
  {
    printf("Item %d: ", i + 1);
    scanf("%d %d", &weights[i], &values[i]);
  }

  int W;
  printf("Enter the capacity of the knapsack: ");
  scanf("%d", &W);

  knapsack(W, weights, values, n);

  return 0;
}
