package Tabulation;

public class CoinChange2Tab {
    public static void main(String[] args) {
        int nums[] = { 1, 2, 3 };
        int target = 4;
        int n = nums.length;

        Integer dp[][] = new Integer[n][target + 1];

        for(int T = 0; T <= target; T++){

            if(T % nums[0] == 0){
                dp[0][T] = 1;
            }
            else{
                dp[0][T] = 0;
            }
        }

        for(int ind = 1; ind < n; ind++){
            for(int tar = 0; tar <= target; tar++){

                int notTake = dp[ind - 1][tar];

                int take = 0;

                if (nums[ind] <= tar) {
                    take = dp[ind][tar - nums[ind]];
                }

                dp[ind][tar] = notTake + take;
            }
        }

        System.out.println(dp[n - 1][target]);
    }
}
