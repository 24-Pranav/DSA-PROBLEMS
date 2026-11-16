public class PalindromeString {

    static Boolean checkPalindrome(String str, int i) {

        if (i >= str.length()) {
            return true;
        }

        if (str.charAt(i) != str.charAt(str.length() - i - 1)) {

            return false;
        }

        checkPalindrome(str, i + 1);

        return true;
    }

    public static void main(String[] args) {

        String str = "MADAM";

        if (checkPalindrome(str, 0)) {

            System.out.println("Palindrome");
        } else {
            System.out.println("Not Palindrome");
        }
    }
}
