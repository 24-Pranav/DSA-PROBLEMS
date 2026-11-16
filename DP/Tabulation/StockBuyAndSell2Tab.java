package Tabulation;

public class StockBuyAndSell2Tab {
    
    public static void main(String[] args) {
        
        int prices[] = {7,1,5,3,6,4};

        int n = prices.length;

        int dp[][] = new int[n + 1][2];

        dp[n][0] = dp[n][1] = 0;

        for(int ind = n - 1; ind >= 0; ind--)
        {
            for(int buy = 0; buy <= 1; buy++)
            {

                long profit = 0;

                if (buy == 1) {
                    
                    profit = Math.max(-prices[ind] + dp[ind + 1][0],
                                                0 + dp[ind + 1][1]);
                }
                else{
                    
                    profit = Math.max(prices[ind] + dp[ind + 1][1], 
                                                0 + dp[ind + 1][0]);
                }

                dp[ind][buy] = (int) profit;
            }
        }

        System.out.println(dp[0][1]);
    }
}
