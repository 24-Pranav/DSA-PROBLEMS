package Greedy;

public class JumpGame {

    public static void main(String[] args) {

        int arr[] = { 1, 2, 4, 1, 1, 0, 2, 5 };

        int maxInd = 0;

        for (int i = 0; i < arr.length; i++) {
            if (i > maxInd) {
                System.out.println(false);
                return;
            }

            maxInd = Math.max(maxInd, i + arr[i]);
        }

        System.out.println(true);
    }
}
