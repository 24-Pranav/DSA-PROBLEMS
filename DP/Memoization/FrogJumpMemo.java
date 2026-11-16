package Memoization;

public class FrogJumpMemo {
    
    static int calJumps(int ind, int arr[], int dp[]){

        if(ind == 0){
            return 0;
        }

        if(dp[ind] != -1){
            return dp[ind];
        }

        int fs = calJumps(ind - 1, arr, dp) + Math.abs(arr[ind] - arr[ind - 1]);

        int ss = Integer.MAX_VALUE;

        if (ind > 1) {
            
            ss = calJumps(ind - 2, arr, dp) + Math.abs(arr[ind] - arr[ind - 2]);
        }

        dp[ind] = Math.min(fs, ss);

        return dp[ind];
    }
    public static void main(String[] args) {
        
        int arr[] = {30,10,60,10,60,50};

        int dp[] = new int[arr.length + 1];

        for(int i = 0; i < dp.length; i++){
            dp[i] = -1;
        }

        System.out.println(calJumps(arr.length - 1,arr,dp));
    }
}