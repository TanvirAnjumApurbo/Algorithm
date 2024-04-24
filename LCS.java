public class LCS {

  public static void main(String args[]) {

    String s1 = "TANVIR";
    String s2 = "APURBO";

    String LCS = lcs(s1, s2);
    int length = LCS.length();

    System.out.println("Longest Common Subsequence Length: " + length + " & String: " + LCS);
  }

  public static String lcs(String s1, String s2) {

    int m = s1.length();
    int n = s2.length();

    int[][] LT = new int[m + 1][n + 1];

    for (int i = 0; i <= m; i++) {
      for (int j = 0; j <= n; j++) {
        if (i == 0 || j == 0) {
          LT[i][j] = 0;
        } else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
          LT[i][j] = LT[i - 1][j - 1] + 1;
        } else
          LT[i][j] = Math.max(LT[i - 1][j], LT[i][j - 1]);
      }
    }

    StringBuilder lcsBuilder = new StringBuilder();
    int i = m, j = n;
    while (i > 0 && j > 0) {
      if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
        lcsBuilder.insert(0, s1.charAt(i - 1));
        i--;
        j--;
      } else if (LT[i - 1][j] > LT[i][j - 1]) {
        i--;
      } else
        j--;
    }
    return lcsBuilder.toString();
  }
}