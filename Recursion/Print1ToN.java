import java.util.*;

public class Print1ToN {
    
    public static void printNum(int i, int n){

        if(i > n){

            return;
        }

        System.out.println(i);

        printNum(i + 1, n);
    }
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        printNum(1,n);
    }
}
