package Memoization;

public class KnapsackMemo {

    public static int f(int ind, int wt[], int val[], int maxWeight, Integer dp[][]){

        if(ind == 0){

            if(wt[0] <= maxWeight){
                return val[0];
            }
            else{
                return 0;
            }
        }

        if (dp[ind][maxWeight] != null) {
            return dp[ind][maxWeight];
        }

        int notTake = f(ind - 1, wt, val, maxWeight, dp);
        int take = -100000;

        if(wt[ind] <= maxWeight){
            take = val[ind] + f(ind - 1, wt, val, maxWeight - wt[ind], dp);
        }

        return dp[ind][maxWeight] = Math.max(notTake,take);
    }
    public static void main(String[] args) {
        int wt[] = {3,4,5};
        int val[] = {30,50,60};

        int maxWeight = 8;

        Integer dp[][] = new Integer[wt.length][maxWeight + 1];

        System.out.println(f(wt.length - 1, wt, val, maxWeight, dp));
    }
}
