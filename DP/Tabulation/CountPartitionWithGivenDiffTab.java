package Tabulation;

public class CountPartitionWithGivenDiffTab {
    public static void main(String[] args) {
        
        int arr[] = {5,2,6,4};
        int d = 3;

        int totSum = 0;

        for(int x : arr){

            totSum += x;
        }

        if (totSum - d < 0 || (totSum - d) % 2 != 0) {
            System.out.println(0);
        }

        int target = (totSum - d) / 2;
        
        int dp[][] = new int[arr.length][target + 1];

        if (arr[0] == 0 ) {
            dp[0][0] = 2;
        }
        else{
            dp[0][0] = 1;
        }

        if (arr[0] != 0 && arr[0] <= target) {
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
