package Tabulation;

public class CoinChangeTab {
    public static void main(String[] args) {
        int nums[] = { 1, 2, 3 };
        int target = 8;
        int n = nums.length;

        Integer dp[][] = new Integer[nums.length][target + 1];

        for(int T = 0; T <= target; T++){

            if (T % nums[0] == 0) {
                dp[0][T] = T / nums[0];
            }
            else{
                dp[0][T] = Integer.MAX_VALUE;
            }
        }

        for(int ind = 1; ind < n; ind++){
            for(int tar = 0; tar <= target; tar++){
                
                int notTake = dp[ind - 1][tar];

                int take = Integer.MAX_VALUE;

                if (nums[ind] <= tar) {
                    take = 1 + dp[ind][tar - nums[ind]];
                }

                dp[ind][tar] = Math.min(notTake, take);
            }
        }
        System.out.println(dp[n - 1][target]);
    }
}
