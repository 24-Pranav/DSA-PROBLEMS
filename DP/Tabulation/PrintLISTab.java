package Tabulation;

import java.util.ArrayList;
import java.util.Collections;

public class PrintLISTab {
    public static void main(String[] args) {

        int arr[] = { 5, 4, 11, 1, 16, 8 };

        int n = arr.length;

        int dp[] = new int[n];

        int hash[] = new int[n];

        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }

        int maxi = 1;
        int lastIndex = 0;

        for (int ind = 0; ind < n; ind++) {
            hash[ind] = ind;

            for (int prev = 0; prev < ind; prev++) {
                if (arr[prev] < arr[ind] && dp[ind] < 1 + dp[prev]) {
                    dp[ind] = 1 + dp[prev];
                    hash[ind] = prev;
                }
            }

            if (dp[ind] > maxi) {

                maxi = dp[ind];
                lastIndex = ind;
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

        System.out.println();
        System.out.println(maxi);
    }
}
