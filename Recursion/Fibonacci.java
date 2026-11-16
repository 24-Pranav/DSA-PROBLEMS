public class Fibonacci {
    
    static int findFibonacci(int n){

        if(n <= 1){

            return n;
        }

        int last = findFibonacci(n - 1);
        int sLast = findFibonacci(n - 2);

        return last + sLast;
    }
    public static void main(String[] args) {
        
        System.out.println(findFibonacci(4));
    }
}
