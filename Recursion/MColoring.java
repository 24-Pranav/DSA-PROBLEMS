import java.util.Scanner;

public class MColoring {

    public static void main(String[] args) {
        // Sample Input Configuration: 
        // 4 nodes, 5 edges, 3 colors allowed
        int v = 4;
        int m = 3;
        int[][] edges = {
            {0, 1},
            {1, 2},
            {2, 3},
            {3, 0},
            {0, 2}
        };

        Solution solver = new Solution();
        boolean canColor = solver.graphColoring(v, edges, m);

        // Output results
        if (canColor) {
            System.out.println("Result: 1 (Graph can be colored using " + m + " colors)");
        } else {
            System.out.println("Result: 0 (Graph cannot be colored using " + m + " colors)");
        }
    }
}

class Solution {
    boolean graphColoring(int v, int[][] edges, int m) {
        // 1. Create a proper V x V Adjacency Matrix initialized to 0
        int adjMatrix[][] = new int[v][v];
        
        // 2. Populate the matrix using the edge list provided in the input
        for(int edge[] : edges){
            int u = edge[0];
            int w = edge[1];
            
            adjMatrix[u][w] = 1;
            adjMatrix[w][u] = 1; // Undirected graph connection
        }
        
        int color[] = new int[v];
        
        return solve(0, color, adjMatrix, v, m);
    }
    
    boolean solve(int node, int color[], int adjMatrix[][], int v, int m){
        if(node == v){
            return true;
        }
        
        for(int i = 1; i <= m; i++){
            if(isSafe(node, color, adjMatrix, v, i)){
                color[node] = i;
                
                if(solve(node + 1, color, adjMatrix, v, m) == true){
                    return true;
                }
                
                color[node] = 0; // Backtrack
            }
        }
        
        return false;
    }
    
    boolean isSafe(int node, int color[], int adjMatrix[][], int v, int col){
        for(int i = 0; i < v; i++){
            if(i != node && adjMatrix[i][node] == 1 && color[i] == col){
                return false;
            }
        }
        
        return true;
    }
}
