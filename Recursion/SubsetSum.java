import java.util.ArrayList;
import java.util.Collections;

class SubsetSum{

    static void findSubsetSum(int arr[],int ind,int sum, int n,ArrayList<Integer> result){

        if(ind == n){
            result.add(sum);
            return;
        }

        findSubsetSum(arr, ind + 1, sum + arr[ind], n, result);

        findSubsetSum(arr, ind + 1, sum, n, result);
    }
    public static void main(String[] args) {
        
        int arr[] = {3,2,1};
        ArrayList<Integer> list = new ArrayList<>();
        findSubsetSum(arr,0,0,arr.length,list);
        Collections.sort(list);

        for (int x : list) {
            System.out.print(x+" ");
        }
    }
}