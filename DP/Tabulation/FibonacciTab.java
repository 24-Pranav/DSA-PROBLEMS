package Tabulation;

public class FibonacciTab {

    public static void main(String[] args) {

        int n = 5;
        // int dp[] = new int[n + 1];

        // With using space

        // dp[0] = 0;
        // dp[1] = 1;

        // for(int i = 2; i <= n; i++){

        // dp[i] = dp[i - 1] + dp[i - 2];
        // }

        // Without using space

        int prev = 1;
        int prev2 = 0;

        for (int i = 2; i <= n; i++) {

            int curr = prev + prev2;

            prev2 = prev;
            prev = curr;
        }

        System.out.println(prev);
    }
}
