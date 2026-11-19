public class MaxSubarrayPartition {
    
    static int f(int i, int k, int n, int arr[])
    {
        if(i == n)
        {
            return 0;
        }

        int len = 0;
        int maxi = Integer.MIN_VALUE;
        int maxAns = Integer.MIN_VALUE;

        for(int ind = i; ind < Math.min(i + k, n); ind++)
        {
            len++;

            maxi = Math.max(maxi, arr[ind]);

            int sum = (len * maxi) + f(ind + 1, k, n, arr);

            maxAns = Math.max(maxAns, sum);
        }

        return maxAns;
    }
    public static void main(String[] args) {
        
        int arr[] = {1,15,7,9,2,5,10};

        int k = 3;
        int n = arr.length;

        System.out.println(f(0, k, n, arr));
    }
}
