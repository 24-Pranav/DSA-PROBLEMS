package DP.Tabulation;

public class NinjasJumpingTab {

    public static void main(String[] args) {
        int points[][] = {{2,1,3},
                        {3,4,6},
                        {10,1,6},
                        {8,3,7}};

    int dp[][] = new int[points.length][4];

    dp[0][0] = Math.max(points[0][1], points[0][2]);
    dp[0][1] = Math.max(points[0][0], points[0][2]);
    dp[0][2] = Math.max(points[0][0], points[0][1]);
    dp[0][3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));

    for(int days = 1; days < points.length; days++){

        for(int last = 0; last < 4; last++){

            dp[days][last] = 0;

            for(int tasks = 0; tasks < 3; tasks++){

                if(tasks != last){

                    int point = points[days][tasks] + dp[days - 1][tasks];
                    dp[days][last] = Math.max(dp[days][last], point);
                }
            }
        }
    }

    System.out.println(dp[points.length - 1][3]);
}
    
}
