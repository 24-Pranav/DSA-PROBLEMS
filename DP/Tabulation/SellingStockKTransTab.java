package Tabulation;

public class SellingStockKTransTab {
    public static void main(String[] args) {
        
        int arr[] = {3,3,5,0,0,3,1,4};

        int n = arr.length;
        int k = 2;

        int dp[][] = new int[n + 1][2 * k + 1];

        for(int ind = n - 1; ind >= 0; ind--)
        {
            for(int trans = 2 * k - 1; trans >= 0; trans--)
            {
                if (trans % 2 == 0) {
            
                    dp[ind][trans] = Math.max(-arr[ind] + dp[ind + 1][trans + 1], 
                                                dp[ind + 1][trans]);
                }
                else{
                    dp[ind][trans] = Math.max(arr[ind] + dp[ind + 1][trans + 1], 
                                            dp[ind + 1][trans]);
                }
            }
        }

        System.out.println(dp[0][0]);
    }
}
