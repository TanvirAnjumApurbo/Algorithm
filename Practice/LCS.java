import java.util.Scanner;

public class LCS {
  public static void main(String[] args) {

    Scanner input = new Scanner(System.in);

    System.out.println("Enter the first String: ");
    String s1 = input.nextLine();

    System.out.println("Enter the second String: ");
    String s2 = input.nextLine();

    String LCS = lcs(s1, s2);
    int length = LCS.length();

    System.out.println("LCS is " + LCS + " Length: " + length);
    // System.out.println("LCS length is " + lcs(s1, s2));

    input.close();

  }

  public static String lcs(String s1, String s2) {
    int m = s1.length();
    int n = s2.length();

    int dp[][] = new int[m + 1][n + 1];

    for (int i = 0; i <= m; i++) {
      for (int j = 0; j <= n; j++) {
        if (i == 0 || j == 0) {
          dp[i][j] = 0;
        } else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
          dp[i][j] = dp[i - 1][j - 1] + 1;
        } else
          dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
      }
    }
    // return dp[m][n];

    StringBuilder lcsBuilder = new StringBuilder();
    int i = m, j = n;
    while (i > 0 && j > 0) {
      if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
        lcsBuilder.insert(0, s1.charAt(i - 1));
        i--;
        j--;
      } else if (dp[i - 1][j] > dp[i][j - 1]) {
        i--;
      } else
        j--;
    }
    return lcsBuilder.toString();
  }
}
