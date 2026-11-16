class StockBuyAndSell2
{
    static long f(int ind, int buy, int prices[])
    {
        if (ind == prices.length) {
            return 0L;
        }

        long profit = 0;

        if (buy == 1) {
            
            profit = Math.max(-prices[ind] + f(ind + 1, 0, prices),
                                        0 + f(ind + 1, 1, prices));
        }
        else{
            
            profit = Math.max(prices[ind] + f(ind + 1, 1, prices), 
                                        0 + f(ind + 1, 0, prices));
        }

        return profit;
    }
    public static void main(String args[])
    {
        int prices[] = {7,1,5,3,6,4};

        System.out.println(f(0, 1, prices));
    }
}