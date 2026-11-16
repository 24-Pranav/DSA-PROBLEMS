import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class LDS {

    public static void main(String[] args) {

        int arr[] = { 1, 16, 7, 8, 4 };

        Arrays.sort(arr);

        int n = arr.length;

        int dp[] = new int[n];
        int hash[] = new int[n];

        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }

        int maxi = 1;
        int lastIndex = 0;

        for (int i = 0; i < n; i++) {
            hash[i] = i;

            for (int j = 0; j < i; j++) {

                if (arr[i] % arr[j] == 0 && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    hash[i] = j;
                }
            }

            if (maxi < dp[i]) {
                maxi = dp[i];
                lastIndex = i;
            }
        }

        ArrayList<Integer> list = new ArrayList<>();
        list.add(arr[lastIndex]);

        while (hash[lastIndex] != lastIndex) {

            lastIndex = hash[lastIndex];
            list.add(arr[lastIndex]);
        }

        Collections.reverse(list);
        
        for (int x : list) {
            System.out.print(x + " ");
        }
    }
}
