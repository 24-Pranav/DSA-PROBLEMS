package Memoization;

public class SubSumEqualsKMemo {

    public static Boolean f(int ind, int target, int arr[], Boolean dp[][]){

        if (target == 0) {
            return true;
        }

        if (ind == 0) {
            return arr[0] == target;
        }

        if (dp[ind][target] != null) {
            return dp[ind][target];
        }

        boolean notTake = f(ind - 1, target, arr,dp);

        boolean take = false;

        if(target >= arr[ind]){
            take = f(ind - 1, target - arr[ind], arr, dp);
        }

        return dp[ind][target] = take || notTake;
    }
    public static void main(String[] args) {
        
        int arr[] = {2,3,1,1};
        int k = 4;

        Boolean dp[][] = new Boolean[arr.length][k + 1];

        System.out.println(f(arr.length - 1, k, arr, dp));
    }
}
