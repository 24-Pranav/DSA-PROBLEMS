public class BurstBalloon {
    
    static int f(int i, int j,  int cost[])
    {
        if(i > j)
        {
            return 0;
        }

        int maxi = Integer.MIN_VALUE;

        for(int ind = i; ind <= j; ind++)
        {
            int costs = cost[i - 1] * cost[ind] * cost[j + 1] + f(i, ind - 1, cost) + 
                                                                f(ind + 1, j, cost);
            
            maxi = Math.max(maxi, costs);
        }

        return  maxi;
    }
    public static void main(String[] args) {
        int arr[] = {3,1,5,8};

        int n = 4;

        int cost[] = new int[n + 2];

        cost[0] = 1;
        cost[n + 1] = 1;

        for(int i = 0; i < n; i++)
        {
            cost[i + 1] = arr[i];
        }

        System.out.println(f(1, n, cost));
    }
}
