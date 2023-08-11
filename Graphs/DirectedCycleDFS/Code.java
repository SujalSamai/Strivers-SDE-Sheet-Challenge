package Graphs.DirectedCycleDFS;

import java.util.ArrayList;

public class Code {
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] vis= new int[V];
        int[] pathVis= new int[V];

        for (int i = 0; i < V; i++) {
            if (vis[i]==0){
                if (dfsCheck(i, adj, vis, pathVis)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfsCheck(int node, ArrayList<ArrayList<Integer>> adj, int[] vis, int[] pathVis) {
        vis[node]=1;
        pathVis[node]=1;

        for (int it : adj.get(node)){
            if (vis[it]==0){
                if (dfsCheck(it, adj, vis, pathVis)){
                    return true;
                }
            }else if (pathVis[it]==1){
                return true;
            }
        }
        pathVis[node]=0;
        return false;
    }
}
