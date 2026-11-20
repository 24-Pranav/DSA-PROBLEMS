import java.util.*;

public class NMeetingInARoom {

    public static ArrayList<Integer> maxMeetings(int[] S, int[] F) {
        int N = S.length;
        ArrayList<Integer> ans = new ArrayList<>();
        if (N == 0) return ans;

        // 2D array to store [Meeting Number (1-based), Start Time, End Time]
        int[][] meetings = new int[N][3];

        for (int i = 0; i < N; i++) {
            meetings[i][0] = i + 1;
            meetings[i][1] = S[i];
            meetings[i][2] = F[i];
        }

        // Sort meetings by end time (column 2) in ascending order
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[2], b[2]));

        // Select the first meeting
        int lastEnd = meetings[0][2];
        ans.add(meetings[0][0]);

        // Iterate through the remaining meetings
        for (int i = 1; i < N; i++) {
            if (meetings[i][1] > lastEnd) {
                ans.add(meetings[i][0]);
                lastEnd = meetings[i][2];
            }
        }

        // Sort selected meeting indices in ascending order
        Collections.sort(ans);
        return ans;
    }

    public static void main(String[] args) {
        // Sample start and finish time arrays
        int[] S = {1, 3, 0, 5, 8, 5};
        int[] F = {2, 4, 6, 7, 9, 9};

        ArrayList<Integer> result = maxMeetings(S, F);

        System.out.println("Selected meeting numbers: " + result);
        System.out.println("Maximum meetings possible: " + result.size());
    }
}
