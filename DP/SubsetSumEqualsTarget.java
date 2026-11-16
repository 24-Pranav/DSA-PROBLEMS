public class SubsetSumEqualsTarget {

    public static boolean f(int ind, int target, int arr[]){

        if (target == 0) {
            return true;
        }

        if (ind == 0) {
            return arr[0] == target;
        }

        boolean notTake = f(ind - 1, target, arr);

        boolean take = false;

        take = f(ind - 1, target - arr[ind], arr);

        return take || notTake;
    }
    public static void main(String[] args) {
        
        int arr[] = {2,3,1,1};
        int k = 4;

        System.out.println(f(arr.length - 1, k, arr));
    }
}