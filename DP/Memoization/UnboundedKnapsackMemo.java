package Memoization;

class UnboundedKnapsackMemo{

    static int f(int ind, int wt[], int val[], int w, Integer dp[][]){

        if(ind == 0){

           return ((int) w/ wt[0]) * val[0];
            
        }

        if (dp[ind][w] != null) {
            
            return dp[ind][w];
        }
        int nottake = 0 + f(ind - 1, wt, val, w, dp);

        int take = Integer.MIN_VALUE;

        if(wt[ind] <= w){
            take = val[ind] + f(ind, wt, val, w - wt[ind], dp);
        }

        return dp[ind][w] = Math.max(nottake, take);
    }
    public static void main(String args[]){

        int wt[] = {2,4,6};
        int val[] = {5,11,13};

        int w = 10;
        
        Integer dp[][] = new Integer[wt.length][w + 1];

        System.out.println(f(wt.length - 1, wt, val, w, dp));
    }
}