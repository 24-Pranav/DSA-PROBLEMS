package SpaceOptimisation;

public class RodCuttingOneArray {
    public static void main(String[] args) {
        
        int arr[] = { 2, 5, 7, 8, 10 };
        int n = 5;

        // int dp[][] = new int[arr.length][n + 1];
        int prev[] = new int[n + 1];

        for(int N = 0; N <= n; N++){

            prev[N] = N * arr[0];
        }

        for(int ind = 1; ind < arr.length; ind++){
            for(int N = 0; N <= n; N++){

                int notTake = 0 + prev[N];

                int take = Integer.MIN_VALUE;

                int rodLength = ind + 1;

                if (rodLength <= N) {
                    take = arr[ind] + prev[N - rodLength];
                }

                prev[N] = Math.max(take, notTake);
            }
        }
        System.out.println(prev[n]);
    }
}
