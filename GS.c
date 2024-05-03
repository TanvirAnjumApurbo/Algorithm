#include <stdio.h>
#include <stdlib.h>
#include <math.h>

int is_diagonally_dominant(int x[][4], int n);

void seidel(int a[][4], float x[], int b[], int n);

float calculate_error(float previous[], float current[], int n);

int main()
{
  int n = 4; // Number of variables
  int a[4][4] = {{900, 7, 5, 8},
                 {11, 1700, 100, -20},
                 {17, -2, 600, -7},
                 {6, 7, 110, 1100}}; // Coefficient matrix
  int b[4] = {-70, 100, 60, 20};     // Constants matrix
  float x[4] = {0};                  // Initial solution

  printf("Initial Solution:");
  for (int i = 0; i < n; i++)
  {
    printf(" %.2f", x[i]);
  }
  printf("\n");

  if (is_diagonally_dominant(a, n))
  {
    float previous_x[4];
    for (int i = 0; i < n; i++)
    {
      previous_x[i] = x[i];
    }
    for (int i = 0; i < 300000; i++)
    {
      seidel(a, x, b, n);
      float error = calculate_error(previous_x, x, n);
      printf("Iteration %d:", i + 1);
      for (int j = 0; j < n; j++)
      {
        printf(" %.6f", x[j]);
      }
      printf(" Error: %.2f%%\n", error);
      for (int j = 0; j < n; j++)
      {
        previous_x[j] = x[j];
      }
    }
  }
  else
  {
    printf("The matrix is not diagonally dominant. The Gauss-Seidel method may not converge.\n");
  }

  return 0;
}

int is_diagonally_dominant(int x[][4], int n)
{
  for (int i = 0; i < n; i++)
  {
    int total = 0;
    for (int j = 0; j < n; j++)
    {
      if (i != j)
      {
        total += abs(x[i][j]);
      }
    }
    if (abs(x[i][i]) < total)
    {
      return 0;
    }
  }
  return 1;
}

void seidel(int a[][4], float x[], int b[], int n)
{
  float temp[4];
  for (int j = 0; j < n; j++)
  {
    float d = b[j];
    for (int i = 0; i < n; i++)
    {
      if (j != i)
      {
        d -= a[j][i] * x[i];
      }
    }
    temp[j] = d / a[j][j];
  }
  for (int i = 0; i < n; i++)
  {
    x[i] = temp[i];
  }
}

float calculate_error(float previous[], float current[], int n)
{
  float error = 0;
  for (int i = 0; i < n; i++)
  {
    float current_error = fabs((current[i] - previous[i]) / current[i]) * 100;
    if (current_error > error)
    {
      error = current_error;
    }
  }
  return error;
}