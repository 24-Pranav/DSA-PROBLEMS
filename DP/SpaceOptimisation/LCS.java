package SpaceOptimisation;

public class LCS{
    public static void main(String[] args) {
        
        String s1 = "acd";
        String s2 = "ced";

        int n = s1.length();
        int m = s2.length();

        // Integer dp[][] = new Integer[n + 1][m + 1];

        int prev[] = new int[n + 1], curr[] = new int[m + 1];

        for(int j = 0; j <= m; j++){
            prev[j] = 0;
        }

        for(int i = 1; i <= n; i++){

            for(int j = 1; j <= m; j++){

                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {

                    curr[j] = 1 + prev[j - 1];
                }
                else{
                    curr[j] = Math.max(prev[j], curr[j - 1]);
                }
                
            }

            prev = curr;
        }

        System.out.println(prev[m]);
    }
}
