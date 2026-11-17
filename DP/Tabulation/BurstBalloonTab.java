package Tabulation;

public class BurstBalloonTab {
    public static void main(String[] args) {
        
        int arr[] = {3,1,5,8};

        int n = 4;

        int cost[] = new int[n + 2];

        cost[0] = 1;
        cost[n + 1] = 1;

        for(int i = 0; i < n; i++)
        {
            cost[i + 1] = arr[i];
        }

        int dp[][] = new int[n + 2][n + 2];

        for(int i = n; i >= 1; i--)
        {
            for(int j = 1; j <= n; j++)
            {
                if(i > j)
                {
                    continue;
                }

                int maxi = Integer.MIN_VALUE;

                for(int ind = i; ind <= j; ind++)
                {
                    int costs = cost[i - 1] * cost[ind] * cost[j + 1] + dp[i][ind - 1] + 
                                                                        dp[ind + 1][j];
                    
                    maxi = Math.max(maxi, costs);
                }

                dp[i][j] = maxi;
            }
        }

        System.out.println(dp[1][n]);
    }
}
