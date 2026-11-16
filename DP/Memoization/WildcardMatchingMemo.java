package Memoization;

public class WildcardMatchingMemo {
    static boolean f(int i, int j, String s1, String s2, Boolean dp[][]) {
        if (i < 0 && j < 0) {
            return true;
        }

        if (i < 0 && j >= 0) {
            return false;
        }

        if (j < 0 && i >= 0) {

            for (int ii = 0; ii <= i; ii++) {
                if (s1.charAt(ii - 1) != '*') {
                    return false;
                }
            }

            return true;
        }

        if (dp[i][j] != null) {
            return dp[i][j];
        }

        if (s1.charAt(i) == s2.charAt(j) || s1.charAt(i) == '?') {
            return dp[i][j] = f(i - 1, j - 1, s1, s2, dp);
        }

        if (s1.charAt(i) == '*') {
            return dp[i][j] = f(i - 1, j, s1, s2, dp) || f(i, j - 1, s1, s2, dp);
        }

        return dp[i][j] = false;
    }

    public static void main(String[] args) {

        String s1 = "*q*?";
        String s2 = "qbqmteaqa";

        // String s1 = "ab?d";
        // String s2 = "abcc";

        int n = s1.length();
        int m = s2.length();

        Boolean dp[][] = new Boolean[n + 1][m + 1];

        System.out.println(f(n - 1, m - 1, s1, s2, dp));
    }
}
