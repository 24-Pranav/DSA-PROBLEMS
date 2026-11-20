import java.util.*;

public class InsertInterval {

    public static ArrayList<ArrayList<Integer>> insertInterval(int[][] intervals,
                                                               int[] newInterval) {
        int n = intervals.length;

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<int[]> res = new ArrayList<>();

        int i = 0;

        while (i < n && intervals[i][1] < newInterval[0]) {
            res.add(intervals[i]);
            i++;
        }

        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }

        res.add(newInterval);

        while (i < n) {
            res.add(intervals[i]);
            i++;
        }

        for (int[] interval : res) {
            ArrayList<Integer> pair = new ArrayList<>();
            pair.add(interval[0]);
            pair.add(interval[1]);
            result.add(pair);
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] intervals = {
            {1, 3},
            {4, 5},
            {6, 7},
            {8, 10}
        };
        int[] newInterval = {5, 6};

        ArrayList<ArrayList<Integer>> ans = insertInterval(intervals, newInterval);
        System.out.println(ans);
    }
}
