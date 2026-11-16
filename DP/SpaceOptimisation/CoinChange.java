package SpaceOptimisation;

/**
 * CoinChange
 */
public class CoinChange {
    public static void main(String[] args) {
        int nums[] = { 1, 2, 3 };
        int target = 8;
        int n = nums.length;

        int prev[] = new int[target + 1];
        int curr[] = new int[target + 1];

        for (int T = 0; T <= target; T++) {

            if (T % nums[0] == 0) {
                prev[T] = T / nums[0];
            } else {
                prev[T] = Integer.MAX_VALUE;
            }
        }

        for (int ind = 1; ind < n; ind++) {
            for (int tar = 0; tar <= target; tar++) {

                int notTake = prev[tar];

                int take = Integer.MAX_VALUE;

                if (nums[ind] <= tar) {
                    take = 1 + curr[tar - nums[ind]];
                }

                curr[tar] = Math.min(notTake, take);
            }

            prev = curr.clone();
        }
        System.out.println(prev[target]);
    }
}