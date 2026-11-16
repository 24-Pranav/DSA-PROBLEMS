public class Triangle {
    
    public static int findMinPath(int mat[][], int i, int j,int n){

        if(i == n - 1){
            return mat[n - 1][j];
        }

        int d = mat[i][j] + findMinPath(mat, i + 1, j, n);

        int dg = mat[i][j] + findMinPath(mat, i + 1, j + 1, n);

        return Math.min(d, dg);
    }
    public static void main(String[] args) {
        
        int mat[][] = {{1},
                        {2,3},
                        {3,6,7},
                        {8,9,6,10}};

        
        int n = mat.length;

        System.out.println(findMinPath(mat,0,0,n));
    }
}
