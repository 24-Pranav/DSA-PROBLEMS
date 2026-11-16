package Tabulation;

public class LISTab {
    public static void main(String[] args) {
        
        int arr[] = {10,9,2,5,3,7,101,18};

        int n = arr.length;
        
        int dp[][] = new int[n + 1][n + 1];
        
        for(int ind = n - 1; ind >= 0; ind--)
        {
            for(int prev_Ind = n - 1; prev_Ind >= -1; prev_Ind--)
            {
                int len = 0 + dp[ind + 1][prev_Ind + 1];

                if(prev_Ind == -1 || arr[ind] > arr[prev_Ind])
                {
                    len = Math.max(len, 1 + dp[ind + 1][ind + 1]);
                }

                dp[ind][prev_Ind + 1] = len;
            }
        }
        System.out.println(dp[0][-1 + 1]);
    }
}
