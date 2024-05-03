#include <stdio.h>
#include <stdlib.h>

double getMaxProfit(int W[], int P[], int n, int M, double quantities[])
{
    double pwRatios[n];

    for (int i = 0; i < n; i++)
    {
        pwRatios[i] = (double)P[i] / W[i];
    }

    for (int i = 0; i < n - 1; i++)
    {
        for (int j = 0; j < n - i - 1; j++)
        {
            if (pwRatios[j] < pwRatios[j + 1])
            {
                double temp = pwRatios[j];
                pwRatios[j] = pwRatios[j + 1];
                pwRatios[j + 1] = temp;

                int tempW = W[j];
                W[j] = W[j + 1];
                W[j + 1] = tempW;

                int tempP = P[j];
                P[j] = P[j + 1];
                P[j + 1] = tempP;
            }
        }
    }

    double totalP = 0;

    for (int i = 0; i < n; i++)
    {
        if (M > 0 && W[i] <= M)
        {
            quantities[i] = 1.0;
            totalP += P[i];
            M -= W[i];
        }
        else if (M > 0)
        {
            quantities[i] = (double)M / W[i];
            totalP += pwRatios[i] * M;
            M = 0;
        }
        else
        {
            quantities[i] = 0.0;
        }
    }

    return totalP;
}

int main()
{
    int W[] = {2, 3, 5, 7, 1, 4, 1};
    int P[] = {10, 5, 15, 7, 6, 18, 3};
    int n = sizeof(W) / sizeof(W[0]);
    int M = 15;
    double quantities[n];

    double maxP = getMaxProfit(W, P, n, M, quantities);

    printf("Maximum Profit: %.2f\n", maxP);
    printf("Quantities of items taken: [");
    for (int i = 0; i < n; i++)
    {
        printf("%.2f", quantities[i]);
        if (i < n - 1)
        {
            printf("  ");
        }
    }
    printf("]\n");

    return 0;
}
