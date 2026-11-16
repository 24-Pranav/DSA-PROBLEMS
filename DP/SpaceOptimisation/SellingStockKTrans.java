package SpaceOptimisation;

public class SellingStockKTrans {
    public static void main(String[] args) {
        
        int arr[] = {3,3,5,0,0,3,1,4};

        int n = arr.length;
        int k = 2;

        // int dp[][] = new int[n + 1][2 * k + 1];
        int after[] = new int[2 * k + 1];
        int curr[] = new int[2 * k + 1];

        for(int ind = n - 1; ind >= 0; ind--)
        {
            for(int trans = 2 * k - 1; trans >= 0; trans--)
            {
                if (trans % 2 == 0) {
            
                    curr[trans] = Math.max(-arr[ind] + after[trans + 1], 
                                                after[trans]);
                }
                else{
                    curr[trans] = Math.max(arr[ind] + after[trans + 1], 
                                            after[trans]);
                }
            }

            after = curr;
        }

        System.out.println(after[0]);
    }
}
