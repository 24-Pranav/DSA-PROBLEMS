package Memoization;

class CoinChange2Memo {

    static int f(int ind, int target, int nums[], Integer dp[][]) {

        if (ind == 0) {

            if (target % nums[ind] == 0) {
                return 1;
            }

            return 0;
        }

        if (dp[ind][target] != null) {
            return dp[ind][target];
        }

        int notTake = f(ind - 1, target, nums, dp);

        int take = 0;

        if (nums[ind] <= target) {
            take = f(ind, target - nums[ind], nums, dp);
        }

        return dp[ind][target] = notTake + take;
    }

    public static void main(String[] args) {
        int nums[] = { 1, 2, 3 };
        int target = 4;
        int n = nums.length;

        Integer dp[][] = new Integer[n][target + 1];

        System.out.println(f(n - 1, target, nums, dp));
    }
}