package SpaceOptimisation;

public class LIS {
    public static void main(String[] args) {
        
        int arr[] = {10,9,2,5,3,7,101,18};

        int n = arr.length;
        
        // int dp[][] = new int[n + 1][n + 1];
        int next[] = new int[n + 1];
        int curr[] = new int[n + 1];
        
        for(int ind = n - 1; ind >= 0; ind--)
        {
            for(int prev_Ind = n - 1; prev_Ind >= -1; prev_Ind--)
            {
                int len = 0 + next[prev_Ind + 1];

                if(prev_Ind == -1 || arr[ind] > arr[prev_Ind])
                {
                    len = Math.max(len, 1 + next[ind + 1]);
                }

                curr[prev_Ind + 1] = len;
            }

            next = curr;
        }
        System.out.println(next[-1 + 1]);
    }
}
