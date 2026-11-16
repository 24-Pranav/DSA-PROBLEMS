package Tabulation;

class FrogJumpTab{

    public static void main(String[] args) {
        
        int arr[] = {30,10,60,10,60,50};

        int dp[] = new int[arr.length];

        dp[0] = 0;

        for(int i = 1; i < arr.length; i++){

            int left = dp[i - 1] + Math.abs(arr[i] - arr[i - 1]);

            int right = Integer.MAX_VALUE;

            if(i > 1){

                right = dp[i - 2] + Math.abs(arr[i] - arr[i - 2]);
            }

            dp[i] = Math.min(left, right);
        }
        
        System.out.println(dp[arr.length - 1]);

    }
}