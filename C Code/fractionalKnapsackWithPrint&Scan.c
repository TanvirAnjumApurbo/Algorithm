#include <stdio.h>

void knapsack(int n, float weight[], float profit[], float capacity)
{
  float x[20], tProfit = 0;
  int i, j, M;
  M = capacity;

  for (i = 0; i < n; i++)
    x[i] = 0.0;

  for (i = 0; i < n; i++)
  {
    if (weight[i] > M)
      break;
    else
    {
      x[i] = 1.0;
      tProfit = tProfit + profit[i];
      M = M - weight[i];
    }
  }

  if (i < n)
    x[i] = M / weight[i];

  tProfit = tProfit + (x[i] * profit[i]);

  printf("\nList of Products: ");
  for (i = 0; i < n; i++)
    printf("%f\t", x[i]);

  printf("\nMaximum profit: %f", tProfit);
}

int main()
{
  float weight[20], profit[20], capacity;
  int num, i, j;
  float pwRatio[20], temp;

  printf("\nEnter the no. of objects: ");
  scanf("%d", &num);

  printf("\nEnter the Weights and Profits of each object: \n");
  for (i = 0; i < num; i++)
  {
    scanf("%f %f", &weight[i], &profit[i]);
  }

  printf("\nEnter the capacity of knapsack: ");
  scanf("%f", &capacity);

  for (i = 0; i < num; i++)
  {
    pwRatio[i] = profit[i] / weight[i];
  }

  for (i = 0; i < num; i++)
  {
    for (j = i + 1; j < num; j++)
    {
      if (pwRatio[i] < pwRatio[j])
      {
        temp = pwRatio[j];
        pwRatio[j] = pwRatio[i];
        pwRatio[i] = temp;

        temp = weight[j];
        weight[j] = weight[i];
        weight[i] = temp;

        temp = profit[j];
        profit[j] = profit[i];
        profit[i] = temp;
      }
    }
  }

  knapsack(num, weight, profit, capacity);
  return (0);
}