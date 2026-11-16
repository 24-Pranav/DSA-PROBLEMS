package SpaceOptimisation;

class SellingStockCooldown
{
    public static void main(String args[])
    {
        int prices[] = {4,9,0,4,10};

        int n = prices.length;

        int front2[] = new int[2];
        int front1[] = new int[2];
        int curr[] = new int[2];

        for(int ind = n - 1; ind >= 0; ind--)
        {
            for(int buy = 0; buy <= 1; buy++)
            {
                if (buy == 1) {
                    
                    curr[buy] = Math.max(-prices[ind] + front1[0],
                                                0 + front1[1]);
                }
                else{
                    
                    curr[buy] = Math.max(prices[ind] + front2[1], 
                                                0 + front1[0]);
                }
            }

            front2 = front1.clone();
            front1 = curr.clone();
        }

        System.out.println(curr[1]);
    }
}