import java.util.Arrays;

public class MinPlatforms {
    public static void main(String[] args) {
        
        int arr[] = { 900, 945, 955, 1100, 1500, 1800 };

        int dep[] = { 920, 1200, 1130, 1150, 1900, 2000 };

        Arrays.sort(arr);
        Arrays.sort(dep);

        int i = 0;
        int j = 0;
        int n = arr.length;

        int count = 0;
        int maxCount = 0;

        while (i < n) {
            
            if(arr[i] <= dep[j])
            {
                count++;
                i++;
            }
            else{
                count--;
                j++;
            }

            maxCount = Math.max(maxCount, count);
        }

        System.out.println(maxCount);
    }
}
