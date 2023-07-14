package Recursion.MColoring;

import java.util.Arrays;

public class Code {
    //here the matrix is like an adjacency graph, each index denotes a node
    //each inside index, shows if it's connected to another node or not
    public boolean graphColoring(boolean[][] graph, int m, int n) {
        int[] color= new int[n];
        Arrays.fill(color, 0);
        //System.out.println(Arrays.deepToString(graph));
        //[[false, true, true, true], [true, false, true, false], [true, true, false, true], [true, false, true, false]]

        return fillColorNodes(0, graph, m, n, color);
    }

    private boolean fillColorNodes(int curr, boolean[][] graph, int m, int n, int[] color) {
        //if we reached to the last node, return true
        if (curr==n) return true;

        //we traverse from 1 to the max no of colors we have been given
        for (int i = 1; i <= m; i++) {
            //if it's safe to color the node with ith color
            if (isSafe(graph[curr], i, color)){
                color[curr]=i;  //color it

                //move to the next node
                if (fillColorNodes(curr+1, graph, m,n, color)) return true;
                else color[curr]=0;
            }
        }
        return false;
    }

    private boolean isSafe(boolean[] graph, int fill, int[] color) {
        //this graph array denotes a particular row of original matrix
        //we check if the current node is connected to a particular node and if it is connected, check if it has the same color
        //as the current one, we chose to color our node, if yes return false
        for (int i = 0; i < graph.length; i++) {
            if (graph[i]==true && color[i]==fill){
                return false;
            }
        }
        return true;
    }
}
