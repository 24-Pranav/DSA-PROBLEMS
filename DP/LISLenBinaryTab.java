import java.util.ArrayList;

public class LISLenBinaryTab {
    
    public static void main(String[] args) {
        
        int arr[] = {1,7,8,4,5,6,-1,9};

        ArrayList<Integer> temp = new ArrayList<>();

        temp.add(arr[0]);

        for(int i = 1; i < arr.length; i++)
        {
            if(arr[i] > temp.get(temp.size() - 1))
            {
                temp.add(arr[i]);
            }
            else{

                int idx = lowerBound(temp, arr[i]);
                temp.set(idx, arr[i]);
            }
        }
        
        System.out.println(temp.size());
    }

    static int lowerBound(ArrayList<Integer> list, int target)
    {
        int left = 0;
        int right = list.size() - 1;

        while(left < right)
        {
            int mid = left + (right - left) / 2;

            if (list.get(mid) < target) {
                
                left = mid + 1;
            }
            else
            {
                right = mid;
            }
        }

        return left;
    }
}
