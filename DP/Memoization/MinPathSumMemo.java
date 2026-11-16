package Memoization;

public class MinPathSumMemo {

    public static int findMinPath(int mat[][], int i, int j, int dp[][]){

        if(i == 0 && j == 0){

            return mat[0][0];
        }

        if (i < 0 || j < 0) {
            
            return 10000000;
        }

        if (dp[i][j] != - 1) {
            return dp[i][j];
        }

        int up = mat[i][j] + findMinPath(mat, i - 1, j, dp);
        int left = mat[i][j] + findMinPath(mat, i, j - 1, dp);

        return dp[i][j] = Math.min(up, left);
    }
    public static void main(String[] args) {

        int mat[][] = {{4,5,6},
                        {1,2,3},
                        {5,8,2}};

        int n = mat.length;
        int m = mat[0].length;

        int dp[][] = new int[mat.length][mat[0].length];

        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp[0].length; j++){

                dp[i][j] = -1;
            }
        }

        System.out.println(findMinPath(mat, n - 1, m - 1, dp));
    }
}
