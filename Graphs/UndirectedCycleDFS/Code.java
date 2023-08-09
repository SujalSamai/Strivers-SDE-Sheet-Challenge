package Graphs.UndirectedCycleDFS;

import java.util.ArrayList;

public class Code {
    public static boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj){
        boolean[] vis= new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!vis[i]){
                if (checkForCycle(i, -1, vis, adj)){
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean checkForCycle(int node, int parent, boolean[] vis, ArrayList<ArrayList<Integer>> adj) {
        vis[node]=true;
        for (Integer it: adj.get(node)){
            if (!vis[it]){
                if (checkForCycle(it, node, vis, adj)){
                    return true;
                }
            }else if(parent!=it){
                return true;
            }
        }
        return false;
    }
}
