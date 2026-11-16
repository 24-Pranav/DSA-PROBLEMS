public class CountSubsetWithSumK {

    public static int f(int arr[], int target, int ind) {

        if (target == 0) {
            return 1;
        }

        if (ind == 0) {
            return arr[ind] == target ? 1 : 0;
        }

        int notTake = f(arr, target, ind - 1);

        int take = 0;

        if (arr[ind] <= target) {
            take = f(arr, target - arr[ind], ind - 1);
        }

        return notTake + take;
    }

    public static void main(String[] args) {

        int arr[] = { 1, 2, 2, 3 };
        int target = 3;

        System.out.println(f(arr, target, arr.length - 1));
    }
}