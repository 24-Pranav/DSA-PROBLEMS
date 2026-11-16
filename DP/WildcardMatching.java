public class WildcardMatching {
    static boolean f(int i, int j, String s1, String s2) {
        if (i < 0 && j < 0) {
            return true;
        }

        if (i < 0 && j >= 0) {
            return false;
        }

        if (j < 0 && i >= 0) {

            for (int ii = 0; ii <= i; ii++) {
                if (s1.charAt(ii) != '*') {
                    return false;
                }
            }

            return true;
        }

        if (s1.charAt(i) == s2.charAt(j) || s1.charAt(i) == '?') {
            return f(i - 1, j - 1, s1, s2);
        }

        if (s1.charAt(i) == '*') {
            return f(i - 1, j, s1, s2) || f(i, j - 1, s1, s2);
        }

        return false;
    }

    public static void main(String[] args) {

        String s1 = "?ay";
        String s2 = "ray";

        int n = s1.length();
        int m = s2.length();

        System.out.println(f(n - 1, m - 1, s1, s2));
    }
}
