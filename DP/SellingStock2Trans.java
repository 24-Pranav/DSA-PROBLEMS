class SellingStock2Trans
{
    static int f(int ind, int buy, int cap, int arr[])
    {
        if (cap == 0) {
            return 0;
        }

        if(ind == arr.length)
        {
            return 0;
        }

        if (buy == 1) {
            
            return Math.max(-arr[ind] + f(ind + 1, 0, cap, arr), 
                                        0 + f(ind + 1, 1, cap, arr));
        }

        return Math.max(arr[ind] + f(ind + 1, 1, cap - 1, arr), 
                                    0 + f(ind + 1, 0, cap, arr));
    }
    public static void main(String args[])
    {
        int arr[] = {3,3,5,0,0,3,1,4};

        System.out.println(f(0, 1, 2, arr));
    }
}