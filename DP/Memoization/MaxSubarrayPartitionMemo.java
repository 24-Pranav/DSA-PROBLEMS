package Memoization;

import java.util.Arrays;

public class MaxSubarrayPartitionMemo {
    
    static int f(int i, int k, int n, int arr[], int dp[])
    {
        if(i == n)
        {
            return 0;
        }

        if(dp[i] != -1)
        {
            return dp[i];
        }

        int len = 0;
        int maxi = Integer.MIN_VALUE;
        int maxAns = Integer.MIN_VALUE;

        for(int ind = i; ind < Math.min(i + k, n); ind++)
        {
            len++;

            maxi = Math.max(maxi, arr[ind]);

            int sum = (len * maxi) + f(ind + 1, k, n, arr, dp);

            maxAns = Math.max(maxAns, sum);
        }

        return dp[i] = maxAns;
    }
    public static void main(String[] args) {
        
        int arr[] = {1,15,7,9,2,5,10};

        int k = 3;
        int n = arr.length;

        int dp[] = new int[n];

        Arrays.fill(dp, -1);

        System.out.println(f(0, k, n, arr, dp));
    }
}
