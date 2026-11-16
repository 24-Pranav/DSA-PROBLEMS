import java.util.ArrayList;

public class PalindromePartitioning {

    public static void main(String[] args) {
        String s = "aab";
        
        ArrayList<ArrayList<String>> partitions = Solution.palinParts(s);
        
        System.out.println("All palindrome partitions for \"" + s + "\":");
        System.out.println(partitions);
    }
}

class Solution {
    public static ArrayList<ArrayList<String>> palinParts(String s) {
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        ArrayList<String> list = new ArrayList<>();
        
        checkPalindrome(result, list, 0, s);
        return result;
    }
    
    static void checkPalindrome(ArrayList<ArrayList<String>> result,
                                ArrayList<String> list, int ind, String s) {
                                    
        if (ind == s.length()) {
            result.add(new ArrayList<>(list));
            return;
        }
        
        for (int i = ind; i < s.length(); ++i) {
            if (isPalindrome(s, ind, i)) {
                // Take the palindrome substring
                list.add(s.substring(ind, i + 1));
                
                // Recur for the remaining substring
                checkPalindrome(result, list, i + 1, s);
                
                // Backtrack: remove the last added substring
                list.remove(list.size() - 1);
            }
        }
    }
        
    static boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }
}
