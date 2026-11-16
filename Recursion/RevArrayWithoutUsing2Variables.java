public class RevArrayWithoutUsing2Variables {
    
    public static void reverseArray(int arr[], int i){

        if(i >= arr.length / 2){

            return;
        }

        int temp = arr[i];
        arr[i] = arr[arr.length - i - 1];
        arr[arr.length - i - 1] = temp;
        
        reverseArray(arr, i + 1);
    }
    public static void main(String[] args) {
        
        int arr[] = {1,2,3,5,4,6};

        System.out.println("Before Reversing");

        for(int x : arr){
            System.out.print(x + " ");
        }

        reverseArray(arr,0);

        System.out.println();
        System.out.println("After Reversing");

        for (int i : arr) {

            System.out.print(i + " ");
        }
    }
}
