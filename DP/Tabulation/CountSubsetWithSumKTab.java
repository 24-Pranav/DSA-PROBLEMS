package Tabulation;

public class CountSubsetWithSumKTab {
    
    public static void main(String[] args) {
        
        int arr[] = {1,2,2,3};
        int target = 3;

        int dp[][] = new int[arr.length][target + 1];

        for(int i = 0; i < arr.length; i++){

            dp[i][0] = 1;
        }

        if (arr[0] <= target) {
            dp[0][arr[0]] = 1;
        }

        for(int ind = 1; ind < arr.length; ind++){

            for(int sum = 0; sum <= target; sum++){

                int notTake = dp[ind - 1][sum];

                int take = 0;

                if (arr[ind] <= sum) {
                    take = dp[ind - 1][sum - arr[ind]];
                }

                dp[ind][sum] = notTake + take;
            }
        }

        System.out.println(dp[arr.length - 1][target]);
    }
}
