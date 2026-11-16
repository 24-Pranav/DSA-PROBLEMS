package Memoization;

class StockBuyAndSell2Memo
{
    static long f(int ind, int buy, int prices[], Integer dp[][])
    {
        if (ind == prices.length) {
            return 0L;
        }

        if(dp[ind][buy] != null)
        {
            return dp[ind][buy];
        }

        long profit = 0;

        if (buy == 1) {
            
            profit = Math.max(-prices[ind] + f(ind + 1, 0, prices, dp),
                                        0 + f(ind + 1, 1, prices, dp));
        }
        else{
            
            profit = Math.max(prices[ind] + f(ind + 1, 1, prices, dp), 
                                        0 + f(ind + 1, 0, prices, dp));
        }

        return dp[ind][buy] = (int) profit;
    }
    public static void main(String args[])
    {
        int prices[] = {7,1,5,3,6,4};

        int n = prices.length;

        Integer dp[][] = new Integer[n][2];

        System.out.println(f(0, 1, prices, dp));
    }
}