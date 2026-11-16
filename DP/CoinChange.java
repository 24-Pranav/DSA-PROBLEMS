class CoinChange {

    static int f(int ind, int target, int nums[]) {

        if (ind == 0) {
            if (target % nums[ind] == 0) {
                return target / nums[ind];
            }

            return 100000;
        }

        int notTake = f(ind - 1, target, nums);

        int take = Integer.MAX_VALUE;

        if (nums[ind] <= target) {
            take = 1 + f(ind, target - nums[ind], nums);
        }

        return Math.min(notTake, take);
    }

    public static void main(String[] args) {
        int nums[] = { 1, 2, 3 };
        int target = 8;
        int n = nums.length;

        System.out.println(f(n - 1, target, nums));
    }
}