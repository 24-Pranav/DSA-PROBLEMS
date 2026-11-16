class CoinChange2 {

    static int f(int ind, int target, int nums[]) {

        if (ind == 0) {

            if (target % nums[ind] == 0) {
                return 1;
            }

            return 0;
        }

        int notTake = f(ind - 1, target, nums);

        int take = 0;

        if (nums[ind] <= target) {
            take = f(ind, target - nums[ind], nums);
        }

        return notTake + take;
    }

    public static void main(String[] args) {
        int nums[] = { 1, 2, 3 };
        int target = 4;
        int n = nums.length;

        System.out.println(f(n - 1, target, nums));
    }
}