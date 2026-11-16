package SpaceOptimisation;

public class MinSumPath {
    
    public static void main(String[] args) {
        
        int mat[][] = {{4,5,6},
                        {1,2,3},
                        {5,8,2}};

        int n = mat.length;
        int m = mat[0].length;

        int prev[] = new int[m];

        for(int i = 0; i < mat.length; i++){

            int curr[] = new int[n];

            for(int j = 0; j < mat[0].length; j++){
                
                if(i == 0 && j == 0){
                    curr[j] = mat[0][0];
                }
                else{
                    int up = Integer.MAX_VALUE;

                    if (i > 0) {
                        up = mat[i][j] + prev[j];
                    }

                    int left = Integer.MAX_VALUE;
                    if(j > 0){
                        left = mat[i][j] + curr[j - 1];
                    }

                    curr[j] = Math.min(up, left);
                }
            }

            prev = curr;
        }

        System.out.println(prev[m - 1]);
    }
}
