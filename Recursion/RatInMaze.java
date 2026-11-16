import java.util.ArrayList;

public class RatInMaze {
    
    public ArrayList<String> ratInMaze(int[][] maze) {
        ArrayList<String> result = new ArrayList<>();
        
        // Safety checks for empty or invalid inputs
        if (maze == null || maze.length == 0 || maze[0].length == 0) {
            return result;
        }
        
        int rows = maze.length;
        int cols = maze[0].length;
        int[][] vis = new int[rows][cols];
        
        // Direction vectors sorted in lexicographical order: D, L, R, U
        int[] di = {+1, 0, 0, -1};
        int[] dj = {0, -1, 1, 0};
        
        // Start exploring only if the entrance cell is open
        if (maze[0][0] == 1) {
            solve(maze, result, vis, di, dj, "", 0, 0, rows, cols);
        }
        
        return result;
    }
    
    private void solve(int[][] maze, ArrayList<String> result, int[][] vis, int[] di, 
                       int[] dj, String move, int i, int j, int rows, int cols) {
            
        // Base Case: Destination reached
        if (i == rows - 1 && j == cols - 1) {
            result.add(move);
            return;
        }
        
        String dir = "DLRU";
        
        // 1. Mark the CURRENT cell as visited
        vis[i][j] = 1;
        
        for (int ind = 0; ind < 4; ind++) {
            int nexti = i + di[ind];
            int nextj = j + dj[ind];
            
            // Validate boundaries, check if it's an open path (1), and verify it's unvisited (0)
            if (nexti >= 0 && nextj >= 0 && nexti < rows && nextj < cols && 
                vis[nexti][nextj] == 0 && maze[nexti][nextj] == 1) {
                    
                    // 2. Move to the next cell recursively
                    solve(maze, result, vis, di, dj, move + dir.charAt(ind), nexti, nextj, rows, cols);
            }
        }
        
        // 3. Backtrack: Unmark the CURRENT cell before leaving this execution frame
        vis[i][j] = 0;
    }

    // Main method to execute the program
    public static void main(String[] args) {
        RatInMaze solver = new RatInMaze();

        // 5x5 Grid from your failing test case
        int[][] maze = {
            {1, 1, 1, 0, 1},
            {1, 0, 1, 1, 1},
            {0, 0, 1, 1, 1},
            {1, 0, 0, 1, 1},
            {1, 0, 0, 0, 1}
        };

        System.out.println("Finding paths for the 5x5 maze...");
        ArrayList<String> paths = solver.ratInMaze(maze);
        
        // Print total path count and the lexicographically ordered combinations
        System.out.println("Total paths found: " + paths.size());
        System.out.println("Paths: " + paths);
    }
}
