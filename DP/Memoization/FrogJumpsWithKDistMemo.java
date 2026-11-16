package DP.Memoization;

/**
 * FrogJumpsWithKDistMemo
 */
public class FrogJumpsWithKDistMemo {

    static int checkJump(int arr[], int dp[], int ind, int k){

        if(ind == 0){

            return 0;
        }


        if(dp[ind] != -1){
            return dp[ind];
        }

        int minSteps = Integer.MAX_VALUE;

        for(int j = 1; j <= k; j++){

            if(ind - j >= 0){
                int jump = checkJump(arr, dp, ind - j, k) + Math.abs(arr[ind] - arr[ind - j]);

                minSteps = Math.min(minSteps, jump);
            }
        }

        dp[ind] = minSteps;
        return dp[ind];

    }
    public static void main(String args[]){

        int arr[] = {30,10,60,10,60,50};

        int k = 4;

        int dp[] = new int[arr.length + 1];

        for(int i = 0; i < dp.length; i++){

            dp[i] = -1;
        }

        System.out.println(checkJump(arr,dp,arr.length - 1, k));
    }
}