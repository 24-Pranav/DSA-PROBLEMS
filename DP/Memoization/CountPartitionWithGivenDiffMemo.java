package Memoization;
public class CountPartitionWithGivenDiffMemo {

    public static int f(int arr[], int target, int ind, Integer dp[][]) {

        

        if (ind == 0) {
            if (target == 0 && arr[0] == 0) {
                return 2;
            }
            if (target == 0 || target == arr[0]) {
                return 1;
            }

            return 0;
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
        int arr[] = {5,2,6,4};
        int d = 3;

        int totSum = 0;

        for(int x : arr){

            totSum += x;
        }

        if (totSum - d < 0 || (totSum - d) % 2 != 0) {
            System.out.println(0);
        }

        int target = (totSum - d) / 2;

        Integer dp[][] = new Integer[arr.length][target + 1];

        System.out.println(f(arr, target, arr.length - 1, dp));
    }
}
