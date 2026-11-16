package SpaceOptimisation;

public class Triangle {
        public static void main(String[] args) {
        
         int mat[][] = {{1},
                        {2,3},
                        {3,6,7},
                        {8,9,6,10}};

        
        int n = mat.length;

        int front[] = new int[n];
        int curr[] = new int[n];

        for(int i = 0; i < n; i++){

            front[i] = mat[n - 1][i];
        }

        for(int i = n - 2; i >= 0; i--){

            for(int j = i; j >= 0; j--){

                int d = mat[i][j] + front[j];

                int dg = mat[i][j] + front[j + 1];

                curr[j] = Math.min(d,dg);
            }

            front = curr;
        }

        System.out.println(front[0]);
    }
}
