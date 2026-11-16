package Memoization;

class SellingStockKTransMemo
{
    static int f(int ind, int trans, int arr[], int n, int k, Integer dp[][])
    {
        if(ind == n || trans == 2 * k)
        {
            return 0;
        }

        if (dp[ind][trans] != null) {
            return dp[ind][trans];
        }

        if (trans % 2 == 0) {
            
            return dp[ind][trans] = Math.max(-arr[ind] + f(ind + 1, trans + 1, arr, n, k, dp), 
                                        0 + f(ind + 1, trans, arr, n, k, dp));
        }

        return dp[ind][trans] = Math.max(arr[ind] + f(ind + 1, trans + 1, arr, n, k, dp), 
                                    0 + f(ind + 1, trans, arr, n, k, dp));
    }
    public static void main(String args[])
    {
        int arr[] = {3,3,5,0,0,3,1,4};

        int n = arr.length;
        int k = 2;

        Integer dp[][] = new Integer[n][2 * k];

        System.out.println(f(0, 0, arr, n, k, dp));
    }
}