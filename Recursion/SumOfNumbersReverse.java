public class SumOfNumbersReverse {
    
    public static int calSum(int n){

        if(n == 0){

            return 0;
        }

        return n + calSum(n - 1);
    }
    public static void main(String args[]){

        System.out.println(calSum(5));
    }
}
