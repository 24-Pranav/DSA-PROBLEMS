import java.util.Arrays;

public class ShortestJobFirst {

    public static void main(String[] args) {

        int bt[] = { 4, 3, 7, 1, 2 };

        Arrays.sort(bt);

        int n = bt.length;

        int wt = 0;
        int time = 0;

        for (int i = 0; i < n; i++) {
            wt += time;
            time += bt[i];
        }

        System.out.println(wt / n);
    }
}
