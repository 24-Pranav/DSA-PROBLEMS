import java.util.Arrays;

public class BitonicSubsequence {
    
    public static void main(String[] args) {
        
        int arr[] = {1,11,2,10,4,5,2,1};

        int n = arr.length;

        int dp1[] = new int[n];

        Arrays.fill(dp1,1);

        for(int ind = 0; ind < n; ind++)
        {
            for(int prev = 0; prev < ind; prev++)
            {
                if(arr[prev] < arr[ind] && dp1[ind] < dp1[prev] + 1)
                {
                    dp1[ind] = dp1[prev] + 1;
                }
            }
        }

        int dp2[] = new int[n];
        Arrays.fill(dp2, 1);

        int maxi = 0;

        for(int ind = n - 1; ind >= 0; ind--)
        {
            for(int prev = n - 1; prev > ind; prev--)
            {
                if(arr[prev] < arr[ind] && dp2[ind] < dp2[prev] + 1)
                {
                    dp2[ind] = dp2[prev] + 1;
                }
            }

            maxi = Math.max(maxi, dp1[ind] + dp2[ind] - 1);
        }

        System.out.println(maxi);
    }
}
