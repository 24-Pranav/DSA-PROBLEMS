package Tabulation;

public class SellingStock2TransTab {
    
    public static void main(String[] args) {
        
        int arr[] = {3,3,5,0,0,3,1,4};

        int n = arr.length;

        int dp[][][] = new int[n + 1][2][3];

        for(int ind = n - 1; ind >= 0; ind--)
        {
            for(int buy = 0; buy <= 1; buy++)
            {
                for(int cap = 1; cap <= 2; cap++)
                {
                    if (buy == 1) {
            
                        dp[ind][buy][cap] = Math.max(-arr[ind] + dp[ind + 1][0][cap], 
                                                    0 + dp[ind + 1][1][cap]);
                    }
                    else{
                        dp[ind][buy][cap] = Math.max(arr[ind] + dp[ind + 1][1][cap - 1],
                                                    0 + dp[ind + 1][0][cap]);
                    }

                }
            }
        }

        System.out.println(dp[0][1][2]);
    }
}
