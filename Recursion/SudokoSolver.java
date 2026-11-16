public class SudokoSolver {

    public void solveSudoku(int[][] mat) {
        solve(mat);
    }
    
    private boolean solve(int mat[][]) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 0) {
                    for (int k = 1; k <= 9; k++) {
                        if (isValid(mat, i, j, k)) {
                            mat[i][j] = k;
                            
                            if (solve(mat)) {
                                return true;
                            } else {
                                mat[i][j] = 0; // Backtrack
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    
    private boolean isValid(int mat[][], int row, int col, int k) {
        for (int i = 0; i < 9; i++) {
            if (mat[i][col] == k) {
                return false;
            }
            if (mat[row][i] == k) {
                return false;
            }
            if (mat[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == k) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // Sample Sudoku board (0 represents empty cells)
        int[][] board = {
            {5, 3, 0, 0, 7, 0, 0, 0, 0},
            {6, 0, 0, 1, 9, 5, 0, 0, 0},
            {0, 9, 8, 0, 0, 0, 0, 6, 0},
            {8, 0, 0, 0, 6, 0, 0, 0, 3},
            {4, 0, 0, 8, 0, 3, 0, 0, 1},
            {7, 0, 0, 0, 2, 0, 0, 0, 6},
            {0, 6, 0, 0, 0, 0, 2, 8, 0},
            {0, 0, 0, 4, 1, 9, 0, 0, 5},
            {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };

        SudokoSolver solver = new SudokoSolver();
        solver.solveSudoku(board);

        // Printing the solved board
        System.out.println("Solved Sudoku Grid:");
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
