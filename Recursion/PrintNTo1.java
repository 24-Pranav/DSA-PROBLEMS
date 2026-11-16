import java.util.*;

public class PrintNTo1 {
    
    public static void printNum(int i, int n){

        if(i < 1){

            return;
        }

        System.out.println(i);

        printNum(i - 1, n);
    }
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        printNum(n,n);
    }
}
