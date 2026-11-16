import java.util.Arrays;

public class CountInversion {

    // Main method to test the logic
    public static void main(String[] args) {
        int[] arr = {2, 4, 1, 3, 5};
        
        System.out.println("Original Array: " + Arrays.toString(arr));
        
        CountInversion solver = new CountInversion();
        long totalInversions = solver.inversionCount(arr);
        
        System.out.println("Number of inversions: " + totalInversions);
        System.out.println("Sorted Array: " + Arrays.toString(arr));
    }

    // Public wrapper method
    public long inversionCount(int arr[]) {
        return mergeSort(arr, 0, arr.length - 1);
    }

    private long mergeSort(int arr[], int low, int high) {
        long count = 0;
        if (low >= high) {
            return count;
        }
        
        int mid = low + (high - low) / 2; // Avoids integer overflow
        
        count += mergeSort(arr, low, mid);
        count += mergeSort(arr, mid + 1, high);
        count += merge(arr, low, mid, high);
        
        return count;
    }

    private long merge(int arr[], int low, int mid, int high) {
        long count = 0;
        
        // Using a primitive array instead of ArrayList reduces memory overhead
        int[] temp = new int[high - low + 1];
        int left = low;
        int right = mid + 1;
        int k = 0;

        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp[k++] = arr[left++];
            } else {
                // All remaining elements in the left subarray are greater than arr[right]
                count += (mid - left + 1);
                temp[k++] = arr[right++];
            }
        }

        // Copy remaining elements of left subarray, if any
        while (left <= mid) {
            temp[k++] = arr[left++];
        }

        // Copy remaining elements of right subarray, if any
        while (right <= high) {
            temp[k++] = arr[right++];
        }

        // Copy the sorted elements back into the original array
        for (int i = low; i <= high; i++) {
            arr[i] = temp[i - low];
        }

        return count;
    }
}
