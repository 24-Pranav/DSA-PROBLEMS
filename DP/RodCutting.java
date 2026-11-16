public class RodCutting {
    static int f(int ind, int arr[], int n){

        if(ind == 0){

            return n * arr[ind];
        }

        int notTake = 0 + f(ind - 1, arr, n);

        int take = Integer.MIN_VALUE;

        int rodLength = ind + 1;

        if(rodLength <= n){
            take = arr[ind] + f(ind, arr, n - rodLength);
        }

        return Math.max(take, notTake);
    }
    public static void main(String[] args) {
        
        int arr[] = {2,5,7,8,10};
        int n = 5;

        System.out.println(f(arr.length - 1, arr,n));
    }
}
