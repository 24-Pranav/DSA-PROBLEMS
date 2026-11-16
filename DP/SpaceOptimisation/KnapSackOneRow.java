package SpaceOptimisation;

class KnapsackOneRow {
    public static void main(String[] args) {

        int wt[] = { 3, 4, 5 };
        int val[] = { 30, 50, 60 };

        int maxWeight = 8;

        int prev[] = new int[maxWeight + 1];

        for (int W = wt[0]; W <= maxWeight; W++) {
            prev[W] = val[0];
        }

        for (int ind = 1; ind < wt.length; ind++) {

            for (int W = maxWeight; W >= 0; W--) {

                int notTake = prev[W];

                int take = -10000;

                if (wt[ind] <= W) {
                    take = val[ind] + prev[W - wt[ind]];
                }

                prev[W] = Math.max(notTake, take);
            }
        }

        System.out.println(prev[maxWeight]);
    }
}
