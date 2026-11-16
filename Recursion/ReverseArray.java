class ReverArray {

    public static void reverseArray(int arr[], int i, int n) {

        if (i >= n) {

            return;
        }

        int temp = arr[i];
        arr[i] = arr[n];
        arr[n] = temp;

        reverseArray(arr, i + 1, n - 1);
    }

    public static void main(String[] args) {

        int arr[] = { 1, 2, 3, 5, 4 };

        System.out.println("Before Reversing");

        for (int x : arr) {
            System.out.print(x + " ");
        }

        reverseArray(arr, 0, arr.length - 1);

        System.out.println();
        System.out.println("After Reversing");

        for (int x : arr) {
            System.out.print(x + " ");
        }
    }
}