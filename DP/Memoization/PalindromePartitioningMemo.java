package Memoization;

public class PalindromePartitioningMemo {

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

    static int f(int i, int n, String str, Integer dp[])
    {
        if(i == n)
        {
            return 0;
        }

        if (dp[i] != null) {
            return dp[i];
        }

        int minCost = Integer.MAX_VALUE;

        for(int j = i; j < n; j++)
        {
            if(isPalindrome(i, j, str))
            {
                int cost = 1 + f(j + 1, n, str, dp);

                minCost = Math.min(minCost, cost);
            }
        }

        return dp[i] = minCost;
    }
    public static void main(String[] args) {
        
        String str = "aabb";
        
        int n = str.length();

        Integer dp[] = new Integer[n];

        System.out.println(f(0, n, str, dp) - 1);
    }   
}