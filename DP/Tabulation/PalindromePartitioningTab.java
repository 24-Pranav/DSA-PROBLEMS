package Tabulation;

public class PalindromePartitioningTab {
    static boolean isPalindrome(int i, int j, String str)
    {
        while(i < j)
        {
            if(str.charAt(i) != str.charAt(j))
            {
                return false;
            }

            i++;
            j--;
        }

        return true;
    }

    public static void main(String[] args) {
        String str = "aabb";
        
        int n = str.length();

        int dp[] = new int[n + 1];

        dp[n] = 0;

        for(int i = n - 1; i >= 0; i--)
        {
            int minCost = Integer.MAX_VALUE;

            for(int j = i; j < n; j++)
            {
                if(isPalindrome(i, j, str))
                {
                    int cost = 1 + dp[j + 1];

                    minCost = Math.min(minCost, cost);
                }
            }

            dp[i] = minCost;
        }

        System.out.println(dp[0] - 1);
    }
}
