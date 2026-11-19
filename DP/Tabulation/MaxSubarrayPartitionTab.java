package Tabulation;

import java.util.Arrays;

public class MaxSubarrayPartitionTab {
    
    public static void main(String[] args) {
        
        int arr[] = {1,15,7,9,2,5,10};

        int k = 3;

        int n = arr.length;

        int dp[] = new int[n + 1];

        for(int i = n - 1; i >= 0; i--)
        {
            int len = 0;
            int maxi = Integer.MIN_VALUE;
            int maxAns = Integer.MIN_VALUE;

            for(int ind = i; ind < Math.min(i + k, n); ind++)
            {
                len++;

                maxi = Math.max(maxi, arr[ind]);

                int sum = (len * maxi) + dp[ind + 1];

                maxAns = Math.max(maxAns, sum);
            }

            dp[i] = maxAns;
        }

        System.out.println(dp[0]);
    }
}
