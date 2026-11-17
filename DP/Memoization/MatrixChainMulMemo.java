package Memoization;

public class MatrixChainMulMemo {

    static int f(int i, int j, int arr[], Integer dp[][]) {

        if (i == j) {
            return 0;
        }

        if (dp[i][j] != null) {
            return dp[i][j];
        }

        int mini = (int) 1e9;

        for (int k = i; k < j; k++) {
            int steps = arr[i - 1] * arr[k] * arr[j] +
                    f(i, k, arr, dp) + f(k + 1, j, arr, dp);

            if (mini > steps) {
                mini = steps;
            }
        }

        return dp[i][j] = mini;
    }

    public static void main(String args[]) {
        int arr[] = { 2, 1, 3, 4 };

        int n = arr.length;

        Integer dp[][] = new Integer[n][n];

        System.out.println(f(1, n - 1, arr, dp));
    }
}
