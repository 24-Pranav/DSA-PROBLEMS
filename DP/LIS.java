public class LIS {
    
    static int f(int ind, int prev_Ind, int arr[], int n)
    {
        if(ind == n)
        {
            return 0;
        }

        int len = 0 + f(ind + 1, prev_Ind, arr,n);

        if(prev_Ind == -1 || arr[ind] > arr[prev_Ind])
        {
            len = Math.max(len, 1 + f(ind + 1, ind, arr, n));
        }

        return len;
    }
    public static void main(String[] args) {
        
        int arr[] = {10,9,2,5,3,7,101,18};

        System.out.println(f(0, -1, arr, arr.length));
    }
}
