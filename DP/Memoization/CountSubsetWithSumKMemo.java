package Memoization;

public class CountSubsetWithSumKMemo {

    public static int f(int arr[], int target, int ind, Integer dp[][]) {

        if (target == 0) {
            return 1;
        }

        if (ind == 0) {
            return arr[ind] == target ? 1 : 0;
        }

        if (dp[ind][target] != null) {
            return dp[ind][target];
        }

        int notTake = f(arr, target, ind - 1, dp);

        int take = 0;

        if (arr[ind] <= target) {
            take = f(arr, target - arr[ind], ind - 1, dp);
        }

        return dp[ind][target] = notTake + take;
    }

    public static void main(String[] args) {

        int arr[] = { 1, 2, 2, 3 };
        int target = 3;
        Integer dp[][] = new Integer[arr.length][target + 1];

        System.out.println(f(arr, target, arr.length - 1, dp));
    }
}