#include <stdio.h>
#include <math.h>

#define MAX_SIZE 100
#define EPSILON 0.0001

void gaussSeidel(int n, double A[MAX_SIZE][MAX_SIZE], double B[MAX_SIZE], int maxIterations);

int main()
{
  int n, i, j, maxIterations;
  double A[MAX_SIZE][MAX_SIZE], B[MAX_SIZE];

  printf("Enter the number of equations: ");
  scanf("%d", &n);

  printf("Enter the coefficients of the equations (A matrix):\n");
  for (i = 0; i < n; i++)
  {
    printf("Equation %d coefficients (space-separated): ", i + 1);
    for (j = 0; j < n; j++)
    {
      scanf("%lf", &A[i][j]);
    }
  }

  printf("Enter the constants (B matrix):\n");
  for (i = 0; i < n; i++)
  {
    printf("Constant for equation %d: ", i + 1);
    scanf("%lf", &B[i]);
  }

  printf("Enter the maximum number of iterations: ");
  scanf("%d", &maxIterations);

  gaussSeidel(n, A, B, maxIterations);

  return 0;
}

void gaussSeidel(int n, double A[MAX_SIZE][MAX_SIZE], double B[MAX_SIZE], int maxIterations)
{
  double X[MAX_SIZE] = {0}; // Initialize all variables to 0
  double prevX[MAX_SIZE];
  int converged = 0;

  for (int k = 0; k < maxIterations && !converged; k++)
  {
    // Copy current solution to prevX
    for (int i = 0; i < n; i++)
    {
      prevX[i] = X[i];
    }

    // Update solution vector X
    for (int i = 0; i < n; i++)
    {
      double sum = 0.0;
      for (int j = 0; j < n; j++)
      {
        if (j != i)
        {
          sum += A[i][j] * X[j];
        }
      }
      X[i] = (B[i] - sum) / A[i][i];
    }

    // Check for convergence
    double maxDiff = 0.0;
    for (int i = 0; i < n; i++)
    {
      double diff = fabs(X[i] - prevX[i]);
      if (diff > maxDiff)
      {
        maxDiff = diff;
      }
    }
    if (maxDiff < EPSILON)
    {
      converged = 1;
    }
  }

  // Print the solution
  printf("Solution:\n");
  for (int i = 0; i < n; i++)
  {
    printf("X[%d] = %.6f\n", i + 1, X[i]);
  }
}
