import java.lang.reflect.Array;
import java.util.Arrays;

public class CountLIS {

    public static void main(String[] args) {

        int arr[] = { 1, 3, 5, 4, 7 };

        int n = arr.length;

        int dp[] = new int[n];
        int cnt[] = new int[n];

        Arrays.fill(dp, 1);
        Arrays.fill(cnt, 1);

        int maxi = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {

                if (arr[i] > arr[j] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    cnt[i] = cnt[j];
                } else if (arr[i] > arr[j] && dp[i] == dp[j] + 1) {
                    cnt[i] += cnt[j];
                }
            }

            maxi = Math.max(maxi, dp[i]);
        }

        int count = 0;

        for (int i = 0; i < n; i++) {
            if (dp[i] == maxi) {
                count += cnt[i];
            }
        }

        System.out.println(count);
    }
}
