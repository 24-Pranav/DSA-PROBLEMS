class SumOfNumbers
{
    public static void calSum(int n, int sum){

        if(n < 1){

            System.out.println(sum);
            return;
        }

        calSum(n - 1, sum + n);
    }
    public static void main(String[] args) {
        
        int n = 5;
        int sum = 0;

        calSum(n,sum);
    }
}