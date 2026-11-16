package Memoization;

class SellingStock2TransMemo
{
    static int f(int ind, int buy, int cap, int arr[], Integer dp[][][])
    {
        if (cap == 0) {
            return 0;
        }

        if(ind == arr.length)
        {
            return 0;
        }

        if(dp[ind][buy][cap] != null)
        {
            return dp[ind][buy][cap];
        }
        
        if (buy == 1) {
            
            return dp[ind][buy][cap] = Math.max(-arr[ind] + f(ind + 1, 0, cap, arr, dp), 
                                        0 + f(ind + 1, 1, cap, arr, dp));
        }

        return dp[ind][buy][cap] = Math.max(arr[ind] + f(ind + 1, 1, cap - 1, arr, dp), 
                                    0 + f(ind + 1, 0, cap, arr, dp));
    }
    public static void main(String args[])
    {
        int arr[] = {3,3,5,0,0,3,1,4};

        int n = arr.length;

        Integer dp[][][] = new Integer[n][2][3];

        System.out.println(f(0, 1, 2, arr, dp));
    }
}