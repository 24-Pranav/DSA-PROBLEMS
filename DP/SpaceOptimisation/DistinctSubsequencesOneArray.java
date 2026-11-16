package SpaceOptimisation;

public class DistinctSubsequencesOneArray {
    public static void main(String[] args) {
        
        String s1 = "babgbag";
        String s2 = "bag";

        int n = s1.length();
        int m = s2.length();

        // Integer dp[][] = new Integer[n + 1][m + 1];

        int prev[] = new int[m + 1]; //curr[] = new int[m + 1];

        prev[0] = 1;

        for(int i = 1; i <= n; i++)
        {
            for(int j = 1; j <= m; j++)
            {
                if(s1.charAt(i - 1) == s2.charAt(j - 1))
                {
                    prev[j] = prev[j - 1] + prev[j];
                }
            } 
        }

        System.out.println(prev[m]);
    }
}

