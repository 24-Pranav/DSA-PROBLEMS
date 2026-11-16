import java.util.ArrayList;
import java.util.List;

public class KthPermutation {
    public static String kthPermutation(int n, int k) {
        int fact = 1;
        List<Integer> numbers = new ArrayList<>();
        
        // Calculate (n-1)! and populate the list with numbers from 1 to n
        for (int i = 1; i <= n; i++) {
            numbers.add(i);
            if (i < n) {
                fact *= i;
            }
        }
        
        k = k - 1; // Convert to 0-based index
        StringBuilder ans = new StringBuilder();
        
        while (true) {
            int index = k / fact;
            ans.append(numbers.get(index));
            numbers.remove(index);
            
            if (numbers.isEmpty()) {
                break;
            }
            
            k %= fact;
            fact /= numbers.size();
        }
        
        return ans.toString();
    }

    public static void main(String[] args) {
        // Test case 1: n = 3, k = 3
        int n1 = 3, k1 = 3;
        System.out.println("The " + k1 + "-th permutation for n = " + n1 + " is: " + kthPermutation(n1, k1)); // Output: 213

        // Test case 2: n = 4, k = 9
        int n2 = 4, k2 = 9;
        System.out.println("The " + k2 + "-th permutation for n = " + n2 + " is: " + kthPermutation(n2, k2)); // Output: 2314

        // Test case 3: n = 3, k = 1
        int n3 = 3, k3 = 1;
        System.out.println("The " + k3 + "-th permutation for n = " + n3 + " is: " + kthPermutation(n3, k3)); // Output: 123
    }
}
