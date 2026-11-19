public class PalindromePartitioning2 {

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

    static int f(int i, int n, String str)
    {
        if(i == n)
        {
            return 0;
        }

        int minCost = Integer.MAX_VALUE;

        for(int j = i; j < n; j++)
        {
            if(isPalindrome(i, j, str))
            {
                int cost = 1 + f(j + 1, n, str);

                minCost = Math.min(minCost, cost);
            }
        }

        return minCost;
    }
    public static void main(String[] args) {
        
        String str = "aabb";
        
        int n = str.length();

        System.out.println(f(0, n, str) - 1);
    }   
}