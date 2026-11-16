package Tabulation;

public class KnapsackTab {
    public static void main(String[] args) {

        int wt[] = { 3, 4, 5 };
        int val[] = { 30, 50, 60 };

        int maxWeight = 8;

        int dp[][] = new int[wt.length][maxWeight + 1];

        for (int W = wt[0]; W <= maxWeight; W++) {
            dp[0][W] = val[0];
        }

        for (int ind = 1; ind < wt.length; ind++) {
            for (int W = 0; W <= maxWeight; W++) {

                int notTake = dp[ind - 1][W];

                int take = -10000;

                if (wt[ind] <= W) {
                    take = val[ind] + dp[ind - 1][W - wt[ind]];
                }

                dp[ind][W] = Math.max(notTake, take);
            }
        }

        System.out.println(dp[wt.length - 1][maxWeight]);
    }
}
