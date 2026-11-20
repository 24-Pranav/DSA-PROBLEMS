public class MinJumps {
    public static void main(String[] args) {

        int arr[] = { 2, 3, 1, 1, 4 };

        int n = arr.length;

        int l = 0;
        int r = 0;
        int jumps = 0;

        int fartest = 0;

        while (r < n - 1) {

            for (int ind = l; ind <= r; ind++) {
                fartest = Math.max(fartest, ind + arr[ind]);
            }

            l = r + 1;
            r = fartest;
            jumps++;
        }

        System.out.println(jumps);
    }
}
