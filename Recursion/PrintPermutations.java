import java.util.ArrayList;

public class PrintPermutations {
    
    static void findPermutations(int arr[], ArrayList<ArrayList<Integer>> result, 
        ArrayList<Integer> list, boolean freq[]){

            if (list.size() == arr.length) {
                result.add(new ArrayList<>(list));
                return;
            }

            for(int i = 0; i < arr.length; i++){

                if (!freq[i]) {
                    list.add(arr[i]);
                    freq[i] = true;
                    findPermutations(arr, result, list, freq);
                    list.remove(list.size() - 1);
                    freq[i] = false;
                }
            }
        }
    public static void main(String args[]){

        int arr[] = {1,2,3};
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        boolean freq[] = new boolean[arr.length];

        findPermutations(arr,result, new ArrayList<>(), freq);

        for (ArrayList<Integer> list : result) {
            
            System.out.println(list + " ");
        }
    }
}
