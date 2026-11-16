package DP.Memoization;

public class NinjasJumpingMemo {
    
    static int solveJumps(int points[][], int dp[][], int days, int last){

        if(days == 0){

            int maxi = 0;

            for(int tasks = 0; tasks < 2; tasks++){

                if(tasks != last){
                    maxi = Math.max(maxi, points[0][tasks]);
                }
            }

            return maxi;   
        }

        if(dp[days][last] != -1){
            return dp[days][last];
        }

        int maxi = 0;

        for(int tasks = 0; tasks < 3; tasks++){

            if(tasks != last){

                int point = points[days][tasks] + solveJumps(points, dp, days - 1, tasks);
                maxi = Math.max(maxi, point);
            }
        }

        return dp[days][last] = maxi;
    }
    public static void main(String[] args) {
        
        int points[][] = {{2,1,3},
                        {3,4,6},
                        {10,1,6},
                        {8,3,7}};

        
        int dp[][] = new int[points.length][4];

        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp[0].length; j++){

                dp[i][j] = -1;
            }
        }
        System.out.println(solveJumps(points,dp, points.length - 1, 3));
    }
}
