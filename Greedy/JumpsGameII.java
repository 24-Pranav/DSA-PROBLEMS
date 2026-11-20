public class JumpsGameII {
    static int f(int i, int jumps, int n, int arr[])
    {
        if(i >= n - 1)
        {
            return jumps;
        }

        int mini = Integer.MAX_VALUE;

        for(int ind = 1; ind <= arr[i]; ind++)
        {
            mini = Math.min(mini, f(i + ind, jumps + 1, n, arr));
        }

        return mini;
    }
    public static void main(String[] args) {
        
        int arr[] = {2,3,1,1,4};

        int n = arr.length;

        System.out.println(f(0,0,n,arr));
    }
}
