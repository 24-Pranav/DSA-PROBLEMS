import java.util.ArrayList;
import java.util.List;

public class PrintPermutationsOptimal {

    static void findPermutations(int arr[], List<ArrayList<Integer>> result, int ind, int n){

        if(ind >= n){

            ArrayList<Integer> list = new ArrayList<>();

            for(int i = 0; i < n; i++){

                list.add(arr[i]);
            }

            result.add(list);
            return;
        }

        for(int i = ind; i < n; i++){

            swap(i, ind, arr);
            findPermutations(arr, result, ind + 1, n);
            swap(i, ind, arr);
        }
    }

    static void swap(int i, int j, int arr[]){

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        
        int arr[] = {1,2,3};
        List<ArrayList<Integer>> result = new ArrayList<>();

        findPermutations(arr, result, 0, arr.length);

        for (ArrayList<Integer> arrayList : result) {
            System.out.println(arrayList);
        }
    }
}