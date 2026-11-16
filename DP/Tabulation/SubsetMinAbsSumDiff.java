package Tabulation;

/**
 * SubsetMinAbsSumDiff
 */
public class SubsetMinAbsSumDiff {

    public static void main(String[] args) {
        
        int arr[] = {1,2,3,4};

        int totalSum = 0;

        for(int i = 0; i < arr.length; i++){

            totalSum += arr[i];
        }

        boolean dp[][] = new boolean[arr.length][totalSum + 1];

        for(int i = 0; i < arr.length; i++){

            dp[i][0] = true;
        }

        if (arr[0] <= totalSum) {
            dp[0][arr[0]] = true;
        }

        for(int ind = 1; ind < arr.length; ind++){

            for(int target = 1; target <= totalSum; target++){

                boolean notTake = dp[ind - 1][target];

                boolean take = false;

                if(target >= arr[ind]){
                    take = dp[ind - 1][target - arr[ind]];
                }

                dp[ind][target] = take || notTake;
            }
        }

        
        int mini = 100000;

        for(int s1 = 0; s1 <= totalSum / 2; s1++){
            if(dp[arr.length - 1][s1] == true){
                mini = Math.min(mini, (totalSum - s1) - s1);
            }
        }

        System.out.println(mini);
    }
}