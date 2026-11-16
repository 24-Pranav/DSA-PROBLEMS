import java.util.ArrayList;

public class PrintSubSequencesEqualsK {

    static void printSubSequence(int i, int arr[], ArrayList<Integer> list, int sum, int s, int n){

        if (i == n) {
            
            if (s == sum) {
                
                for(int x : list){

                    System.out.print(x + " ");
                }

                System.out.println();
            }
            return;
        }

        list.add(arr[i]);
        s += arr[i];
        printSubSequence(i + 1, arr, list, sum, s, n); //take

        s -= arr[i];
        list.remove(list.size() - 1);
        printSubSequence(i + 1, arr, list, sum, s, n); //not take
    }
    public static void main(String[] args) {
        
        int arr[] = {1,2,1};
        ArrayList<Integer> list = new ArrayList<>();
        int sum = 2;

        printSubSequence(0, arr, list, sum, 0, arr.length);
    }
}
