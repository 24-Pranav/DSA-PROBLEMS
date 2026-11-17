package Tabulation;

import java.util.Arrays;

public class CostToCutStickTab {
    
    public static void main(String[] args) {
        
        int arr[] = {3,5,1,4};

        int n = arr.length;

        int c = 7;

        int[] cuts = new int[n + 2];
        cuts[0] = 0;
        cuts[n + 1] = c;
        for (int i = 0; i < n; i++) {
            cuts[i + 1] = arr[i];
        }

        Arrays.sort(cuts);

        int dp[][] = new int[n + 2][n + 2];

        for(int i = n; i>=1; i--)
        {
            for(int j = 1; j <= n; j++)
            {
                if(i > j)
                {
                    continue;
                }

                int mini = Integer.MAX_VALUE;

                for(int ind = i; ind <= j; ind++)
                {
                    int cost = cuts[j + 1] - cuts[i - 1] + dp[i][ind - 1] + 
                                                        dp[ind + 1][j];

                    mini = Math.min(mini, cost);
                }

                dp[i][j] = mini;
            }
        }

        System.out.println(dp[1][n]);
    }
}
