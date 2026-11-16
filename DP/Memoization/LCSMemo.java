package Memoization;

public class LCSMemo {

    static int f(int i, int j, String s1, String s2, Integer dp[][]) {

        if (i == 0 || j == 0) {
            return 0;
        }

        if (dp[i][j] != null) {
            return dp[i][j];
        }

        if (s1.charAt(i - 1) == s2.charAt(j - 1)) {

            return dp[i][j] = 1 + f(i - 1, j - 1, s1, s2, dp);
        }

        return dp[i][j] = Math.max(f(i - 1, j, s1, s2, dp), f(i, j - 1, s1, s2, dp));
    }

    public static void main(String[] args) {

        String s1 = "acd";
        String s2 = "ced";

        int n = s1.length();
        int m = s2.length();

        Integer dp[][] = new Integer[n + 1][m + 1];

        System.out.println(f(n, m, s1, s2, dp));
    }
}
