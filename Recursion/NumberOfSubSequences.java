public class NumberOfSubSequences {

    static int calSubsequences(int i, int arr[], int sum, int s, int n){

        if (i == n) {
            
            if (s == sum) {
                return 1;
            }
            else{
                return 0;
            }
        }
        
        s += arr[i];
        int left = calSubsequences(i + 1, arr, sum, s, n);

        s -= arr[i];
        int right = calSubsequences(i + 1, arr, sum, s, n);

        return left + right;
    }
    public static void main(String[] args) {
        
        int arr[] = {2,1,1};
        int sum = 2;

        System.out.println(calSubsequences(0, arr, sum, 0, arr.length));
    }
}
