public class EditDistance {

    static int f(int i, int j, String s1, String s2) {
        if (j < 0) {
            return i + 1;
        }

        if (i < 0) {
            return j + 1;
        }

        if (s1.charAt(i) == s2.charAt(j)) {
            return f(i - 1, j - 1, s1, s2);
        }

        return Math.min(1 + f(i, j - 1, s1, s2),
                Math.min(1 + f(i - 1, j, s1, s2),
                        1 + f(i - 1, j - 1, s1, s2)));
    }

    public static void main(String[] args) {

        String s1 = "horse";
        String s2 = "ros";

        int n = s1.length();
        int m = s2.length();

        System.out.println(f(n - 1, m - 1, s1, s2));
    }
}
