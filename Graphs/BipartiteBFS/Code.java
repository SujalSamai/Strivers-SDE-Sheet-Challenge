package Graphs.BipartiteBFS;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Code {
    public static boolean isBipartite(int[][] graph){
        int[] color= new int[graph.length];
        Arrays.fill(color, -1);
        for (int i = 0; i < graph.length; i++) {
            if (color[i] == -1){
                if (!bfsCheck(graph, i, color)){
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean bfsCheck(int[][] graph, int node, int[] color) {
        Queue<Integer> q= new LinkedList<>();
        color[node]=1;
        q.add(node);
        while (!q.isEmpty()){
            int cur= q.poll();
            for (int neighbour : graph[cur]){
                if (color[neighbour]==-1){
                    color[neighbour] = 1 - color[cur];
                    q.add(neighbour);
                }else if (color[neighbour]==color[cur]){
                    return false;
                }
            }
        }
        return true;
    }
}
