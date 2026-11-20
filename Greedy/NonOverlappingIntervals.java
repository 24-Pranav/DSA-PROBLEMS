import java.util.*;

public class NonOverlappingIntervals {

    public static int minRemoval(int intervals[][]) {
        int n = intervals.length;
        if (n == 0)
            return 0;

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        int count = 1;
        int lastEndTime = intervals[0][1];

        for (int i = 1; i < n; i++) {
            if (intervals[i][0] >= lastEndTime) {
                count = count + 1;
                lastEndTime = intervals[i][1];
            }
        }

        return n - count;
    }

    public static void main(String[] args) {
        int[][] intervals = {
                { 1, 2 },
                { 2, 3 },
                { 3, 4 },
                { 1, 3 }
        };

        int result = minRemoval(intervals);
        System.out.println("Minimum intervals to remove: " + result);
    }
}
