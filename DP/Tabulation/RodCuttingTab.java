package Tabulation;

public class RodCuttingTab {
    public static void main(String[] args) {
        
        int arr[] = { 2, 5, 7, 8, 10 };
        int n = 5;

        int dp[][] = new int[arr.length][n + 1];

        for(int N = 0; N <= n; N++){

            dp[0][N] = N * arr[0];
        }

        for(int ind = 1; ind < arr.length; ind++){
            for(int N = 0; N <= n; N++){

                int notTake = 0 + dp[ind - 1][N];

                int take = Integer.MIN_VALUE;

                int rodLength = ind + 1;

                if (rodLength <= N) {
                    take = arr[ind] + dp[ind][N - rodLength];
                }

                dp[ind][N] = Math.max(take, notTake);
            }
        }
        System.out.println(dp[arr.length - 1][n]);
    }
}
