package Tabulation;

public class MinSumPathTab {
    public static void main(String[] args) {
        
        int mat[][] = {{4,5,6},
                        {1,2,3},
                        {5,8,2}};

        int dp[][] = new int[mat.length][mat[0].length];


        for(int i = 0; i < mat.length; i++){

            for(int j = 0; j < mat[0].length; j++){
                
                if(i == 0 && j == 0){
                    dp[0][0] = mat[0][0];
                }
                else{
                    int up = Integer.MAX_VALUE;

                    if (i > 0) {
                        up = mat[i][j] + dp[i - 1][j];
                    }

                    int left = Integer.MAX_VALUE;
                    if(j > 0){
                        left = mat[i][j] + dp[i][j - 1];
                    }

                    dp[i][j] = Math.min(up, left);
                }
            }
        }

        System.out.println(dp[mat.length - 1][(mat[0].length) - 1]);
    }
}
