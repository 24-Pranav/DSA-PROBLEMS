import java.util.*;

class CombinationSum{

    public static List<List<Integer>> checkCombination(int ind, int arr[], List<List<Integer>> result,int target, ArrayList<Integer> ds,int n){

        if (ind == n) {
            if (target == 0) {
                
                result.add(new ArrayList<>(ds));
            }

            return result;
        }

        if (arr[ind] <= target) {
                
            ds.add(arr[ind]);
            checkCombination(ind, arr, result, target - arr[ind], ds, n);
            ds.remove(ds.size() - 1);
        }
        
        checkCombination(ind + 1, arr, result, target, ds, n);
        return result;
    }

    public static void main(String[] args) {
        
        int arr[] = {2,3,6,7};
        int target = 7;

        List<List<Integer>> result = new ArrayList<>();

        checkCombination(0,arr,result,target,new ArrayList<>(),arr.length);

        for (List<Integer> list : result) {
            System.out.println(list + " ");
        }
    }
}