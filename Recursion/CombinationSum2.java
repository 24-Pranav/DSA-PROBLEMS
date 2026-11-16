import java.util.*;

class CombinationSum2{

    public static void findCombination(int arr[], int target, List<List<Integer>> result,
                                        ArrayList<Integer> list, int index, int n){

                
                if (target == 0) {
                    
                    result.add(new ArrayList<>(list));
                    return;
                }

                for(int i = index; i < n; i++){

                    if (i > index && arr[i] == arr[i - 1]) {
                        continue;
                    }

                    if (arr[i] > target) {
                        break;
                    }

                list.add(arr[i]);
                findCombination(arr, target - arr[i], result, list, i + 1, n);
                list.remove(list.size() - 1);
            }
    }
    public static void main(String[] args) {
        
        int arr[] = {1,1,1,2,2};
        int target = 4;

        Arrays.sort(arr);

        List<List<Integer>> result = new ArrayList<>();

        ArrayList<Integer> list = new ArrayList<>();

        findCombination(arr,target,result,list,0,arr.length);

        for (List<Integer> list2 : result) {
            
            System.out.println(list2 + " ");
        }
    }
}