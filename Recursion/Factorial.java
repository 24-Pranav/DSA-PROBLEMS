public class Factorial {
    
    public static int calFact(int n){

        if(n == 0){

            return 1;
        }

        return n * calFact(n - 1);
    }
    public static void main(String[] args) {
        
        System.out.println(calFact(5));
    }
}
