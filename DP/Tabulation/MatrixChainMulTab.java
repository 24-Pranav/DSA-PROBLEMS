package Tabulation;

public class MatrixChainMulTab {
    
    public static void main(String[] args) {

        int arr[] = { 2, 1, 3, 4 };

        int n = arr.length;

        int dp[][] = new int[n][n];

        for(int i = 1; i < n; i++)
        {
            dp[i][i] = 0;
        }

        for(int i = n - 1; i >= 1; i--)
        {
            for(int j = i + 1; j < n; j++)
            {
                int mini = (int) 1e9;

                for (int k = i; k < j; k++) {
                    int steps = arr[i - 1] * arr[k] * arr[j] +
                            dp[i][k] + dp[k + 1][j];

                    if (mini > steps) {
                        mini = steps;
                    }
                }

                dp[i][j] = mini;
            }
        }

        System.out.println(dp[1][n - 1]);
    }
   
}
