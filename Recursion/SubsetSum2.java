import java.util.ArrayList;

class SubsetSum2{
    
    static void findSubsetSum(int arr[], ArrayList<ArrayList<Integer>> result,
        ArrayList<Integer> list, int ind){

            result.add(new ArrayList<>(list));

            for(int i = ind; i < arr.length; i++){
                
                if (i!=ind && arr[i] == arr[i - 1]) {
                    continue;
                }

                list.add(arr[i]);
                findSubsetSum(arr, result, list, i + 1);
                list.remove(list.size() - 1);
            }
        }
    public static void main(String[] args) {
        
        int arr[] = {1,2,2,2,3,3};
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        findSubsetSum(arr,result,new ArrayList<>(),0);
        
        for (ArrayList<Integer> arrayList : result) {
            
            System.out.println(arrayList + " ");
        }
    }
}