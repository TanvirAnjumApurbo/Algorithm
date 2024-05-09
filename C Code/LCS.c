#include <stdio.h>
#include <string.h>

// Function to find the length of the longest common subsequence
// and return the LCS string
char *lcs(char *s1, char *s2)
{
  int m = strlen(s1);
  int n = strlen(s2);

  // Allocate memory for the 2D array
  int **dp = (int **)malloc((m + 1) * sizeof(int *));
  for (int i = 0; i <= m; i++)
  {
    dp[i] = (int *)malloc((n + 1) * sizeof(int));
  }

  // Initialize the dp array
  for (int i = 0; i <= m; i++)
  {
    for (int j = 0; j <= n; j++)
    {
      if (i == 0 || j == 0)
      {
        dp[i][j] = 0;
      }
      else if (s1[i - 1] == s2[j - 1])
      {
        dp[i][j] = dp[i - 1][j - 1] + 1;
      }
      else
      {
        dp[i][j] = (dp[i - 1][j] > dp[i][j - 1]) ? dp[i - 1][j] : dp[i][j - 1];
      }
    }
  }

  // Find the LCS string
  char *lcsString = (char *)malloc((dp[m][n] + 1) * sizeof(char));
  int index = dp[m][n];
  lcsString[index] = '\0';
  int i = m, j = n;
  while (i > 0 && j > 0)
  {
    if (s1[i - 1] == s2[j - 1])
    {
      lcsString[--index] = s1[i - 1];
      i--;
      j--;
    }
    else if (dp[i - 1][j] > dp[i][j - 1])
    {
      i--;
    }
    else
    {
      j--;
    }
  }

  // Free memory allocated for dp array
  for (int i = 0; i <= m; i++)
  {
    free(dp[i]);
  }
  free(dp);

  return lcsString;
}

int main()
{
  char s1[] = "TANVIR";
  char s2[] = "APURBO";

  char *LCS = lcs(s1, s2);
  int length = strlen(LCS);

  printf("Longest Common Subsequence Length: %d & String: %s\n", length, LCS);

  // Free memory allocated for LCS string
  free(LCS);

  return 0;
}
