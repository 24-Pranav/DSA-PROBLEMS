package Memoization;

/**
 * UniquePathsMemo
 */
public class UniquePathsMemo {

    static int countUniquePaths(int m1, int n1, int dp[][]){

        if(m1 == 0 && n1 == 0){

            return 1;
        }

        if (m1 < 0 || n1 < 0) {
            return 0;
        }

        if (dp[m1][n1] != -1) {
            return dp[m1][n1];
        }

        int up = countUniquePaths(m1 - 1, n1, dp);
        int left = countUniquePaths(m1, n1 - 1, dp);

        return dp[m1][n1] = up + left;
    }
    public static void main(String args[]){

        int m1 = 3;
        int n1 = 7;

        int dp[][] = new int[m1][n1];


        for(int i = 0; i < m1; i++){
            for(int j = 0; j < n1; j++){

                dp[i][j] = -1;
            }
        }

        System.out.println(countUniquePaths(m1 - 1,n1 - 1,dp));
    }
}