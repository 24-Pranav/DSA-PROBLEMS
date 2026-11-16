package DP.Tabulation;

public class FrogJumpWithKDistTab {
    
    public static void main(String[] args) {
        
        int arr[] = {30,10,60,10,60,50};
        int k = 4;

        int dp[] = new int[arr.length];

        dp[0] = 0;

        for(int i = 1; i < arr.length; i++){

            int minSteps = Integer.MAX_VALUE;

            for(int j = 1; j <= k; j++){

                if(i - j >= 0){

                    int jumps = dp[i - j] + Math.abs(arr[i] - arr[i - j]);
                    minSteps = Math.min(minSteps, jumps);
                }
            }

            dp[i] = minSteps;
        }

        System.out.println(dp[arr.length - 1]);
    }
}
