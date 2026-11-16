package SpaceOptimisation;

public class SellingStockTransFee {
    
    public static void main(String[] args) {
        
        int prices[] = {1,3,2,8,4,9};

        int n = prices.length;

        int fee = 2;
        // int dp[][] = new int[n + 1][2];
        // int ahead[] = new int[2], curr[] = new int[2];

        int aheadBuy, aheadNotBuy, currBuy, currNotBuy;

        aheadNotBuy = aheadBuy = 0;

        for(int ind = n - 1; ind >= 0; ind--)
        {
            currBuy = Math.max(-prices[ind]  + aheadNotBuy,
                                        0 + aheadBuy);
        
            currNotBuy = Math.max(prices[ind] - fee + aheadBuy, 
                                        0 + aheadNotBuy);

            aheadBuy = currBuy;
            aheadNotBuy = currNotBuy;
        }

        System.out.println(aheadBuy);
    }
}
