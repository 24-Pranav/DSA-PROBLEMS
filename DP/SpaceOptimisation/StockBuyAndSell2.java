package SpaceOptimisation;

public class StockBuyAndSell2 {
    
    public static void main(String[] args) {
        
        int prices[] = {7,1,5,3,6,4};

        int n = prices.length;

        // int dp[][] = new int[n + 1][2];
        int ahead[] = new int[2], curr[] = new int[2];

        ahead[0] = ahead[1] = 0;

        for(int ind = n - 1; ind >= 0; ind--)
        {
            for(int buy = 0; buy <= 1; buy++)
            {

                long profit = 0;

                if (buy == 1) {
                    
                    profit = Math.max(-prices[ind] + ahead[0],
                                                0 + ahead[1]);
                }
                else{
                    
                    profit = Math.max(prices[ind] + ahead[1], 
                                                0 + ahead[0]);
                }

                curr[buy] = (int) profit;
            }

            ahead = curr;
        }

        System.out.println(ahead[1]);
    }
}
