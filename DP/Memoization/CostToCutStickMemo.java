package Memoization;

import java.util.Arrays;

public class CostToCutStickMemo {
    
    static int f(int i, int j, int arr[], Integer dp[][])
    {
        if(i > j)
        {
            return 0;
        }

        if (dp[i][j] != null) {
            return dp[i][j];
        }

        int mini = Integer.MAX_VALUE;

        for(int ind = i; ind <= j; ind++)
        {
            int cost = arr[j + 1] - arr[i - 1] + f(i, ind - 1, arr, dp) + 
                                                f(ind + 1, j, arr, dp);

            mini = Math.min(mini, cost);
        }

        return dp[i][j] = mini;
    }

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
        
        Integer dp[][] = new Integer[n + 1][n + 1];

        System.out.println(f(1, n, cuts, dp));
    }
}

