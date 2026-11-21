public class MinPlatformsBruteForce {

    public static void main(String[] args) {

        int arr[] = { 900, 945, 955, 1100, 1500, 1800 };

        int dep[] = { 920, 1200, 1130, 1150, 1900, 2000 };

        int maxCount = 0;

        // four conditions brute force
        /*
         * boolean firstLater = (arr[j] <= arr[i] && dep[j] >= dep[i]);
         * boolean firstMiddle = (arr[j] <= arr[i] && dep[j] >= arr[i] && dep[j] <=
         * dep[i]);
         * boolean middleLater = (arr[j] >= arr[i] && arr[j] <= dep[i] && dep[j] >=
         * dep[i]);
         * boolean middleMiddle = (arr[j] >= arr[i] && dep[j] <= dep[i]);
         */

        for (int i = 0; i < arr.length; i++) {
            int count = 1;

            for (int j = 0; j < dep.length; j++) {
                if (i == j) {
                    continue;
                }

                if (arr[j] <= dep[i] && dep[j] >= arr[i]) {
                    count++;
                }

                maxCount = Math.max(maxCount, count);
            }
        }

        System.out.println(maxCount);
    }
}
