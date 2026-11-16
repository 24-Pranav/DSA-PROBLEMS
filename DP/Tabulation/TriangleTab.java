package Tabulation;

public class TriangleTab {
    
    public static void main(String[] args) {
        
         int mat[][] = {{1},
                        {2,3},
                        {3,6,7},
                        {8,9,6,10}};

        
        int n = mat.length;
        int m = mat[0].length;

        int dp[][] = new int[n][];

        for(int i = 0; i < n; i++){
            dp[i] = new int[mat[i].length]; 
        }
        
        for(int i = 0; i < n; i++){

            dp[n - 1][i] = mat[n - 1][i];
        }

        for(int i = n - 2; i >= 0; i--){

            for(int j = i; j >= 0; j--){

                int d = mat[i][j] + dp[i + 1][j];

                int dg = mat[i][j] + dp[i + 1][j + 1];

                dp[i][j] = Math.min(d,dg);
            }
        }

        System.out.println(dp[0][0]);
    }
}
