import java.util.ArrayList;
import java.util.List;

public class NQueens {
    // Main method to run and test the program
    public static void main(String[] args) {
        Solution solver = new Solution();
        int n = 4; // Change this value to test different board sizes (e.g., 4, 8)
        
        List<List<String>> results = solver.solveNQueens(n);
        
        System.out.println("Total solutions for N = " + n + ": " + results.size() + "\n");
        
        // Print all found configurations
        int solutionCount = 1;
        for (List<String> board : results) {
            System.out.println("Solution #" + (solutionCount++));
            for (String row : board) {
                System.out.println(row);
            }
            System.out.println(); // Blank line between boards
        }
    }
}

class Solution {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        
        // Initialize an empty board with '.'
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        
        // Lookup arrays for O(1) safety checks
        int[] leftRow = new int[n];
        int[] lowerDiagonal = new int[2 * n - 1];
        int[] upperDiagonal = new int[2 * n - 1];
        
        solve(0, board, ans, leftRow, upperDiagonal, lowerDiagonal, n);
        return ans;
    }

    private void solve(int col, char[][] board, List<List<String>> ans, 
                       int[] leftRow, int[] upperDiagonal, int[] lowerDiagonal, int n) {
        // Base case: If all columns are filled, save the board configuration
        if (col == n) {
            ans.add(constructBoard(board));
            return;
        }

        for (int row = 0; row < n; row++) {
            // Check if the current position is safe using the lookup arrays
            if (leftRow[row] == 0 && 
                lowerDiagonal[row + col] == 0 && 
                upperDiagonal[n - 1 + col - row] == 0) {
                
                // Action: Place the queen
                board[row][col] = 'Q';
                leftRow[row] = 1;
                lowerDiagonal[row + col] = 1;
                upperDiagonal[n - 1 + col - row] = 1;
                
                // Recurse: Move to the next column
                solve(col + 1, board, ans, leftRow, upperDiagonal, lowerDiagonal, n);
                
                // Backtrack: Remove the queen
                board[row][col] = '.';
                leftRow[row] = 0;
                lowerDiagonal[row + col] = 0;
                upperDiagonal[n - 1 + col - row] = 0;
            }
        }
    }

    // Helper method to convert the 2D char array into a list of strings
    private List<String> constructBoard(char[][] board) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            res.add(new String(board[i]));
        }
        return res;
    }
}
