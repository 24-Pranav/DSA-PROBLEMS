package Memoization;

public class BurstBalloonMemo {
    
    static int f(int i, int j,  int cost[], Integer dp[][])
    {
        if(i > j)
        {
            return 0;
        }

        if (dp[i][j] != null) {
            return dp[i][j];
        }

        int maxi = Integer.MIN_VALUE;

        for(int ind = i; ind <= j; ind++)
        {
            int costs = cost[i - 1] * cost[ind] * cost[j + 1] + f(i, ind - 1, cost, dp) + 
                                                                f(ind + 1, j, cost, dp);
            
            maxi = Math.max(maxi, costs);
        }

        return dp[i][j] = maxi;
    }
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

        Integer dp[][] = new Integer[n + 2][n + 2];

        System.out.println(f(1, n, cost, dp));
    }
}

