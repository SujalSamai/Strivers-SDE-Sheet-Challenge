package Graphs.BipartiteDFS;

import java.util.Arrays;

public class Code {
    public static boolean isBipartite(int[][] graph){
        int[] color= new int[graph.length];
        Arrays.fill(color, -1);
        for (int i = 0; i < graph.length; i++) {
            if(color[i]==-1){
                if (!dfsCheck(graph, i, color)){
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean dfsCheck(int[][] graph, int node, int[] color) {
        for (int neighbour : graph[node]){
            if (color[neighbour] == -1){
                color[neighbour] = 1 - color[node];
                if (!dfsCheck(graph, neighbour, color)){
                    return false;
                }
            }else if (color[neighbour] == color[node]){
                return false;
            }
        }
        return true;
    }
}
