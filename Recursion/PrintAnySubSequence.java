import java.util.ArrayList;

public class PrintAnySubSequence {

    static boolean printAnySequence(int i, int arr[], ArrayList<Integer> list, int sum, int s, int n){

        if (i == n) {
            
            if (s == sum) {
                
                for(int x : list){

                    System.out.print(x + " ");
                }

                System.out.println();
                return true;
            }
            else{
                return false;
            }
        }
        

        list.add(arr[i]);
        s += arr[i];
        if(printAnySequence(i + 1, arr, list, sum, s, n)){
            return true;
        }

        s -= arr[i];
        list.remove(list.size() - 1);
        if(printAnySequence(i + 1, arr, list, sum, s, n)){
            return true;
        }

        return false;
    }
    public static void main(String[] args) {
        
        int arr[] = {2,1,1};
        ArrayList<Integer> list = new ArrayList<>();
        int sum = 2;

        printAnySequence(0, arr, list, sum, 0, arr.length);
    }
}
