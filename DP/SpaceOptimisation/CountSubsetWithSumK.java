package SpaceOptimisation;

public class CountSubsetWithSumK {
    
    public static void main(String[] args) {
        
        int arr[] = {1,2,2,3};
        int target = 3;

        int curr[] = new int[arr.length];
        int prev[] = new int[arr.length];

        for(int i = 0; i < arr.length; i++){

            prev[i] = 1;
        }

        if (arr[0] <= target) {
            prev[arr[0]] = 1;
        }

        for(int ind = 1; ind < arr.length; ind++){

            for(int sum = 0; sum <= target; sum++){

                int notTake = prev[sum];

                int take = 0;

                if (arr[ind] <= sum) {
                    take = prev[sum - arr[ind]];
                }

                curr[sum] = notTake + take;
            }

            curr = prev;
        }

        System.out.println(prev[target]);
    }
}
