package Tabulation;

public class DistinctSubsequencesTab {
    public static void main(String[] args) {
        
        String s1 = "babgbag";
        String s2 = "bag";

        int n = s1.length();
        int m = s2.length();

        Integer dp[][] = new Integer[n + 1][m + 1];

        for(int i = 0; i <= n; i++)
        {
            dp[i][0] = 1;
        }

        for(int j = 1; j <= m; j++)
        {
            dp[0][j] = 0;
        }


        for(int i = 1; i <= n; i++)
        {
            for(int j = 1; j <= m; j++)
            {
                if(s1.charAt(i - 1) == s2.charAt(j - 1))
                {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                }
                else{

                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        System.out.println(dp[n][m]);
    }
}
