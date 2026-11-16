package Memoization;

public class TriangleMemo {
    
    public static int findMinPath(int mat[][], int i, int j,int n,int dp[][]){

        if(i == n - 1){
            dp[i][j] = mat[i][j];
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        int d = mat[i][j] + findMinPath(mat, i + 1, j, n,dp);

        int dg = mat[i][j] + findMinPath(mat, i + 1, j + 1, n,dp);

        return dp[i][j] = Math.min(d, dg);
    }

    public static void main(String args[]){

        int mat[][] = {{1},
                        {2,3},
                        {3,6,7},
                        {8,9,6,10}};

        
        int n = mat.length;
        int m = mat[0].length;

        int dp[][] = new int[n][];

        for(int i = 0; i < mat.length; i++){
            dp[i] = new int[mat[i].length]; 

            for(int j = 0; j < mat[i].length; j++){

                dp[i][j] = -1;
            }
        }

        System.out.println(findMinPath(mat, 0,0, n,dp));
    }
}
