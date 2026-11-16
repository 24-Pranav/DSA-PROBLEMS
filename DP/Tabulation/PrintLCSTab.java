package Tabulation;

public class PrintLCSTab {
    public static void main(String[] args) {
        
        String s1 = "acd";
        String s2 = "ced";

        int n = s1.length();
        int m = s2.length();

        Integer dp[][] = new Integer[n + 1][m + 1];

        for(int i = 0; i <= n; i++){
            dp[i][0] = 0;
        }

        for(int j = 0; j <= m; j++){
            dp[0][j] = 0;
        }

        for(int i = 1; i <= n; i++){

            for(int j = 1; j <= m; j++){

                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {

                    dp[i][j] = 1 + dp[i - 1][j - 1];
                }
                else{
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
                
            }
        }

        int len = dp[n][m];

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < len; i++){
            sb.append('$');
        }

        int i = n;
        int j = m;

        int index = sb.length() - 1;

        while(i > 0 && j > 0)
        {
            if(s1.charAt(i - 1) == s2.charAt(j - 1))
            {
                sb.setCharAt(index,s1.charAt(i - 1));
                index--;
                i--;
                j--;
            }
            else if (dp[i - 1][j] > dp[i][j - 1]) {
                
                i = i - 1;
            }
            else
            {
                j = j - 1;
            }
        }

        System.out.println(sb.toString());
    }
}
