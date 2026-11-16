package SpaceOptimisation;

public class EditDistance {

    public static void main(String[] args) {

        String s1 = "horse";
        String s2 = "ros";

        int n = s1.length();
        int m = s2.length();

        // int dp[][] = new int[n + 1][m + 1];
        int prev[] = new int[m + 1], curr[] = new int[m + 1];

        // for(int i = 0; i <= n; i++)
        // {
        // dp[i][0] = i;
        // }

        for (int j = 0; j <= m; j++) {
            prev[j] = j;
        }

        for (int i = 1; i <= n; i++) {
            // curr[0] = i;

            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    curr[j] = prev[j - 1];
                } else {
                    curr[j] = 1 + Math.min(prev[j],
                            Math.min(curr[j - 1],
                                    prev[j - 1]));
                }
            }

            prev = curr;
        }

        System.out.println(prev[m]);
    }
}
