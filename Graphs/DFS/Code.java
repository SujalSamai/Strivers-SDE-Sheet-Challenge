package Graphs.DFS;

import java.util.ArrayList;

public class Code {
    public static ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj){
        boolean[] vis= new boolean[V];
        ArrayList<Integer> res= new ArrayList<>();

        for (int i = 0; i < V; i++) {
            if (!vis[i]){
                dfs(i,vis,adj,res);
            }
        }
        return res;
    }

    private static void dfs(int node, boolean[] vis, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> res) {
        if (vis[node]) return;

        res.add(node);
        vis[node]=true;

        for (Integer it: adj.get(node)){
            if (!vis[it]){
                dfs(it, vis, adj, res);
            }
        }
    }
}
