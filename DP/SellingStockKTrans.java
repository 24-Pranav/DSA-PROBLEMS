class SellingStockKTrans
{
    static int f(int ind, int trans, int arr[], int n, int k)
    {
        if(ind == n || trans == 2 * k)
        {
            return 0;
        }

        if (trans % 2 == 0) {
            
            return Math.max(-arr[ind] + f(ind + 1, trans + 1, arr, n, k), 
                                        0 + f(ind + 1, trans, arr, n, k));
        }

        return Math.max(arr[ind] + f(ind + 1, trans + 1, arr, n, k), 
                                    0 + f(ind + 1, trans, arr, n, k));
    }
    public static void main(String args[])
    {
        int arr[] = {3,3,5,0,0,3,1,4};

        int n = arr.length;
        int k = 2;

        System.out.println(f(0, 0, arr, n, k));
    }
}