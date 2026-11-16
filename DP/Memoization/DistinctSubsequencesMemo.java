package Memoization;

public class DistinctSubsequencesMemo {

    static int f(int i, int j, String s1, String s2, Integer dp[][])
    {

        if (j < 0) {
            
            return 1;
        }

        if(i < 0)
        {
            return 0;
        }
        
        if (dp[i][j] != null) {
            return dp[i][j];
        }

        if(s1.charAt(i) == s2.charAt(j))
        {
            return dp[i][j] = f(i - 1, j - 1, s1, s2, dp) + f(i - 1, j, s1, s2, dp);
        }
        else{

            return dp[i][j] = f(i - 1, j, s1, s2, dp);
        }
    }
    public static void main(String[] args) {
        
        String s1 = "babgbag";
        String s2 = "bag";

        int n = s1.length();
        int m = s2.length();

        Integer dp[][] = new Integer[n][m];

        System.out.println(f(n - 1, m - 1, s1, s2, dp));
    }
}
