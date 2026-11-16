package Tabulation;

public class LISTraceBackTab {
    public static void main(String[] args) {
        
        int arr[] = {5,4,11,1,16,8};

        int n = arr.length;

        int dp[] = new int[n];

        for(int i = 0; i < n; i++)
        {
            dp[i] = 1;
        }

        int maxi = 1;

        for(int ind = 0; ind < n; ind++)
        {
            for(int prev = 0; prev < ind; prev++)
            {
                if(arr[prev] < arr[ind])
                {
                    dp[ind] = Math.max(dp[ind], 1 + dp[prev]);
                }
            }

            maxi = Math.max(maxi, dp[ind]);
        }

        System.out.println(maxi);
    }
}
