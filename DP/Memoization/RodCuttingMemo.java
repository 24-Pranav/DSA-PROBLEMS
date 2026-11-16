package Memoization;

public class RodCuttingMemo {
    static int f(int ind, int arr[], int n, Integer dp[][]) {

        if (ind == 0) {

            return n * arr[ind];
        }

        if (dp[ind][n] != null) {
            return dp[ind][n];
        }

        int notTake = 0 + f(ind - 1, arr, n, dp);

        int take = Integer.MIN_VALUE;

        int rodLength = ind + 1;

        if (rodLength <= n) {
            take = arr[ind] + f(ind, arr, n - rodLength, dp);
        }

        return dp[ind][n] = Math.max(take, notTake);
    }

    public static void main(String[] args) {

        int arr[] = { 2, 5, 7, 8, 10 };
        int n = 5;

        Integer dp[][] = new Integer[arr.length][n + 1];

        System.out.println(f(arr.length - 1, arr, n, dp));
    }
}
