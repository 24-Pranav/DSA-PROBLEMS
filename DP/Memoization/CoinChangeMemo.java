package Memoization;

class CoinChangeMemo {

    static int f(int ind, int target, int nums[], Integer dp[][]) {

        if (ind == 0) {
            if (target % nums[ind] == 0) {
                return target / nums[ind];
            }

            return 100000;
        }

        if (dp[ind][target] != null) {
            return dp[ind][target];
        }

        int notTake = f(ind - 1, target, nums, dp);

        int take = Integer.MAX_VALUE;

        if (nums[ind] <= target) {
            take = 1 + f(ind, target - nums[ind], nums, dp);
        }

        return dp[ind][target] = Math.min(notTake, take);
    }

    public static void main(String[] args) {
        int nums[] = { 1, 2, 3 };
        int target = 8;
        int n = nums.length;

        Integer dp[][] = new Integer[nums.length][target + 1];
        System.out.println(f(n - 1, target, nums, dp));
    }
}