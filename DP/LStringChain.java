import java.util.Arrays;

public class LStringChain {
    
    public static void main(String[] args) {
        
        String arr[] = {"ba", "b", "a", "bca", "bda", "bdca"};

        int n = arr.length;
        
        int dp[] = new int[n];

        Arrays.fill(dp, 1);

        int maxi = 1;

        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < i; j++)
            {
                if(checkPossible(arr[i], arr[j]) && dp[i] < dp[j] + 1)
                {
                    dp[i] = dp[j] + 1;
                }
            }

            if (dp[i] > maxi) {
                maxi = dp[i];
            }
        } 

        System.out.println(maxi);
    }
    static boolean checkPossible(String s1, String s2)
    {
        if (s1.length() != s2.length() + 1) {
            
            return false;
        } 

        int first = 0;
        int second = 0;

        while(first < s1.length())
        {
            if (second < s2.length() && s1.charAt(first) == s2.charAt(second)) {
                
                first++;
                second++;
            }
            else{
                first++;
            }
        }

        if (first == s1.length() && second == s2.length()) {
            return true;
        }

        return false;
    } 
}
