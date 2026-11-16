package Tabulation;

public class SubSumEqualsKTab {
    
    public static void main(String[] args) {
        
        int arr[] = {2,3,1,1};
        int k = 4;

        boolean dp[][] = new boolean[arr.length][k + 1];

        for(int i = 0; i < arr.length; i++){

            dp[i][0] = true;
        }

        for(int ind = 1; ind < arr.length; ind++){

            for(int target = 1; target <= k; target++){

                boolean notTake = dp[ind - 1][target];

                boolean take = false;

                if(target >= arr[ind]){
                    take = dp[ind - 1][target - arr[ind]];
                }

                dp[ind][target] = take || notTake;
            }
        }

        System.out.println(dp[arr.length - 1][k]);
    }
}
