#include <stdio.h>
#include <stdlib.h>

typedef struct Item
{
  int profit;
  int weight;
  double pwRatio;
  int index;
} Item;

int compare(const void *a, const void *b)
{
  Item *itemA = (Item *)a;
  Item *itemB = (Item *)b;
  return itemB->pwRatio > itemA->pwRatio;
}

double knapsack(int P[], int W[], int M, int n)
{
  double arr[n];

  for (int i = 0; i < n; i++)
  {
    arr[i] = (double)P[i] / W[i];
  }

  Item table[n];
  for (int i = 0; i < n; i++)
  {
    table[i].profit = P[i];
    table[i].weight = W[i];
    table[i].pwRatio = arr[i];
    table[i].index = i;
  }

  qsort(table, n, sizeof(Item), compare);

  double currentMaxProfit = 0;
  double currentWeight = 0;
  double counts[n];

  for (int i = 0; i < n; i++)
  {
    if (currentWeight + table[i].weight <= M)
    {
      currentMaxProfit += table[i].profit;
      counts[table[i].index] = 1;
      currentWeight += table[i].weight;
    }
    else
    {
      double fraction = (M - currentWeight) / (double)table[i].weight;
      currentMaxProfit += table[i].pwRatio * (M - currentWeight);
      counts[table[i].index] = fraction;
      break;
    }
  }

  for (int i = 0; i < n; i++)
  {
    printf("%f    ", counts[i]);
  }
  printf("\n");

  return currentMaxProfit;
}

int main()
{
  int P[] = {10, 5, 15, 7, 6, 18, 3};
  int W[] = {2, 3, 5, 7, 1, 4, 1};
  int M = 15;
  int n = sizeof(P) / sizeof(P[0]);

  double maxProfit = knapsack(P, W, M, n);
  printf("Maximum Profit: %f\n", maxProfit);

  return 0;
}
