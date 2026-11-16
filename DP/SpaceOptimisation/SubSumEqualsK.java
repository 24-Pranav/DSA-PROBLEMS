package SpaceOptimisation;

public class SubSumEqualsK {
    
    public static void main(String[] args) {
        
        int arr[] = {2,3,1,1};
        int k = 4;

        boolean prev[] = new boolean[k + 1];
        boolean curr[] = new boolean[k + 1];

        for(int i = 0; i < arr.length; i++){

            curr[i] = true;
        }

        for(int ind = 1; ind < arr.length; ind++){

            for(int target = 1; target <= k; target++){

                boolean notTake = prev[target];

                boolean take = false;

                if(target >= arr[ind]){
                    take = prev[target - arr[ind]];
                }

                curr[target] = take || notTake;
            }

            prev = curr;
        }

        System.out.println(prev[k]);
    }
}

