package Tabulation;

public class UnboundedKnapsack {
    
        public static void main(String[] args) {
            
        int wt[] = {2,4,6};
        int val[] = {5,11,13};

        int w = 10;
        int n = wt.length;

        Integer dp[][] = new Integer[n][w + 1];

        for(int W = 0; W <= w; W++){

            dp[0][W] = ((int) W/wt[0]) * val[0];
        }

        for(int ind = 1; ind < n; ind++){
            for(int W = 0; W <= w; W++){

                int nottake = 0 + dp[ind - 1][W];

                int take = Integer.MIN_VALUE;

                if(wt[ind] <= W){
                    take = val[ind] + dp[ind][W - wt[ind]];
                }

                dp[ind][W] = Math.max(nottake, take);
            }
        }
        System.out.println(dp[n - 1][w]);
    }
}
