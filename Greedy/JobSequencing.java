import java.util.*;

public class JobSequencing {

    public static ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {
        int n = deadline.length;

        int jobInfo[][] = new int[n][2];

        for (int i = 0; i < profit.length; i++) {
            jobInfo[i][0] = deadline[i];
            jobInfo[i][1] = profit[i];
        }

        Arrays.sort(jobInfo, (a, b) -> Integer.compare(b[1], a[1]));

        int maxDeadline = 0;

        for (int i = 0; i < n; i++) {
            maxDeadline = Math.max(maxDeadline, deadline[i]);
        }

        boolean vis[] = new boolean[maxDeadline + 1];

        int calProfit = 0;
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = jobInfo[i][0]; j > 0; j--) {
                if (!vis[j]) {
                    vis[j] = true;
                    count++;
                    calProfit += jobInfo[i][1];
                    break;
                }
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(count);
        ans.add(calProfit);

        return ans;
    }

    public static void main(String[] args) {
        int[] deadline = {4, 1, 1, 1};
        int[] profit = {20, 10, 40, 30};

        ArrayList<Integer> result = jobSequencing(deadline, profit);
        System.out.println("Jobs done and maximum profit: " + result);
    }
}
