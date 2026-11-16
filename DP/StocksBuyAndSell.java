public class StocksBuyAndSell {
    
    public static void main(String[] args) {
        
        int arr[] = {7,1,5,3,6,4};
        
        int n = arr.length;

        int mini = arr[0];
        int profit = 0;

        for(int i = 1; i < n; i++)
        {
            int cost =  arr[i] - mini;

            profit = Math.max(profit, cost);

            mini = Math.min(mini, arr[i]);
        }

        System.out.println(profit);
    }
}
