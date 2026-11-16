package Memoization;

public class EditDistanceMemo {

    static int f(int i, int j, String s1, String s2, Integer dp[][]) {

        if (j < 0) {
            return i + 1;
        }

        if (i < 0) {
            return j + 1;
        }

        if (dp[i][j] != null) {
            return dp[i][j];
        }

        if (s1.charAt(i) == s2.charAt(j)) {
            return dp[i][j] = f(i - 1, j - 1, s1, s2, dp);
        }

        return dp[i][j] = Math.min(1 + f(i, j - 1, s1, s2, dp),
                Math.min(1 + f(i - 1, j, s1, s2, dp),
                        1 + f(i - 1, j - 1, s1, s2, dp)));
    }

    public static void main(String[] args) {

        String s1 = "horse";
        String s2 = "ros";

        int n = s1.length();
        int m = s2.length();

        Integer dp[][] = new Integer[n][m];

        System.out.println(f(n - 1, m - 1, s1, s2, dp));
    }
}

