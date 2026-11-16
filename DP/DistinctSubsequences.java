public class DistinctSubsequences {

    static int f(int i, int j, String s1, String s2)
    {

        if (j < 0) {
            
            return 1;
        }

        if(i < 0)
        {
            return 0;
        }
        
        if(s1.charAt(i) == s2.charAt(j))
        {
            return f(i - 1, j - 1, s1, s2) + f(i - 1, j, s1, s2);
        }
        else{

            return f(i - 1, j, s1, s2);
        }
    }
    public static void main(String[] args) {
        
        String s1 = "babgbag";
        String s2 = "bag";

        int n = s1.length();
        int m = s2.length();

        System.out.println(f(n - 1, m - 1, s1, s2));
    }
}
