package Tabulation;

public class UniquePathsTab {
    
    public static void main(String[] args) {
        
    int m1 = 3;
    int n1 = 7;

    int dp[][] = new int[m1][n1];

    for(int i = 0; i < m1; i++){

        for(int j = 0; j < n1; j++){

            if(i == 0 && j == 0){
                dp[i][j] = 1;
            }
            else{

                int up = 0;
                int left = 0;

                if(i > 0){
                    up = dp[i - 1][j];
                }

                if (j > 0) {
                    left = dp[i][j - 1];
                }

                dp[i][j] = up + left;
            }
        }
    }

    System.out.println(dp[m1 - 1][n1 - 1]);
    }
}
