public class MinPathSum {

    public static int findMinPath(int mat[][], int i, int j){

        if(i == 0 && j == 0){

            return mat[0][0];
        }

        if(i < 0 || j < 0){

            return 1000000000;
        }

        int up = mat[i][j] + findMinPath(mat, i - 1, j);
        int left = mat[i][j] + findMinPath(mat, i, j - 1);

        return Math.min(up, left);
    }
    public static void main(String[] args) {
        
        int mat[][] = {{4,5,6},
                        {1,2,3},
                        {5,8,2}};

        int n = mat.length;
        int m = mat[0].length;

        System.out.println(findMinPath(mat, n - 1, m - 1));
    }
}
