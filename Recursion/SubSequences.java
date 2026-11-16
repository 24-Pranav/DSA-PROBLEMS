import java.util.ArrayList;

class SubSequences {

    static void findSubSequence(int i, int arr[], ArrayList<Integer> list, int n) {

        if (i == n) {

            for (int x : list) {

                System.out.print(x + " ");
            }

            if (list.size() == 0) {

                System.out.print("{}");
            }

            System.out.println();
            return;
        }

        list.add(arr[i]);
        findSubSequence(i + 1, arr, list, n);
        list.remove(list.size() - 1);
        findSubSequence(i + 1, arr, list, n);
    }

    public static void main(String[] args) {

        int arr[] = { 3, 1, 2 };

        ArrayList<Integer> list = new ArrayList<>();

        findSubSequence(0, arr, list, arr.length);
    }
}