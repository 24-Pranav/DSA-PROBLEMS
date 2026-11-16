package Tabulation;

public class WildcardMatchingTab {
    public static void main(String[] args) {

        String s1 = "ab?d";
        String s2 = "abcc";

        int n = s1.length();
        int m = s2.length();

        boolean dp[][] = new boolean[n + 1][m + 1];

        dp[0][0] = true;

        for (int j = 1; j <= m; j++) {
            dp[0][j] = false;
        }

        for (int i = 1; i <= n; i++) {
            boolean flag = true;

            for (int ii = 1; ii <= i; ii++) {
                if (s1.charAt(ii - 1) != '*') {
                    flag = false;
                    break;
                }
            }

            dp[i][0] = flag;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1) || s1.charAt(i - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (s1.charAt(i - 1) == '*') {

                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                } else {
                    dp[i][j] = false;
                }
            }
        }

        System.out.println(dp[n][m]);
    }
}
