package Memoization;

public class LISMemo {
    
    static int f(int ind, int prev_Ind, int arr[], int n, Integer dp[][])
    {
        if(ind == n)
        {
            return 0;
        }

        if (dp[ind][prev_Ind + 1] != null) {
            return dp[ind][prev_Ind + 1];
        }

        int len = 0 + f(ind + 1, prev_Ind, arr,n, dp);

        if(prev_Ind == -1 || arr[ind] > arr[prev_Ind])
        {
            len = Math.max(len, 1 + f(ind + 1, ind, arr, n, dp));
        }

        return dp[ind][prev_Ind + 1] = len;
    }
    public static void main(String[] args) {
        
        int arr[] = {10,9,2,5,3,7,101,18};

        int n = arr.length;

        Integer dp[][] = new Integer[n][n + 1];

        System.out.println(f(0, -1, arr, n, dp));
    }
}
