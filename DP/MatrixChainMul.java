public class MatrixChainMul {

    static int f(int i, int j, int arr[]) {

        if (i == j) {
            return 0;
        }

        int mini = (int) 1e9;

        for (int k = i; k < j; k++) {
            int steps = arr[i - 1] * arr[k] * arr[j] +
                    f(i, k, arr) + f(k + 1, j, arr);

            if (mini > steps) {
                mini = steps;
            }
        }

        return mini;
    }

    public static void main(String args[]) {
        int arr[] = { 2, 1, 3, 4 };

        int n = arr.length;

        System.out.println(f(1, n - 1, arr));
    }
}
