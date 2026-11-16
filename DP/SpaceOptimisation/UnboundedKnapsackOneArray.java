package SpaceOptimisation;

public class UnboundedKnapsackOneArray {
    
        public static void main(String[] args) {
            
        int wt[] = {2,4,6};
        int val[] = {5,11,13};

        int w = 10;
        int n = wt.length;

        int prev[] = new int[w + 1];

        for(int W = 0; W <= w; W++){

            prev[W] = ((int) W/wt[0]) * val[0];
        }

        for(int ind = 1; ind < n; ind++){
            for(int W = 0; W <= w; W++){

                int nottake = 0 + prev[W];

                int take = Integer.MIN_VALUE;

                if(wt[ind] <= W){
                    take = val[ind] + prev[W - wt[ind]];
                }

                prev[W] = Math.max(nottake, take);
            }
        }
        System.out.println(prev[w]);
    }
}
