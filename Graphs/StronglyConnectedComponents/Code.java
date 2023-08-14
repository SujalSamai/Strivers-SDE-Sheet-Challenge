package Graphs.StronglyConnectedComponents;

import java.util.ArrayList;
import java.util.Stack;

public class Code {
    //Kosaraju's Algorithm
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj){
        boolean[] vis = new boolean[V];
        Stack<Integer> st= new Stack<>();
        for (int i = 0; i < V; i++) {
            if (!vis[i]){
                sortInFinishingTime(i, vis, adj, st);
            }
        }

        //Reverse the graph, in a different transposed adjacency list
        ArrayList<ArrayList<Integer>> adjT = new ArrayList<>();
        for (int i=0; i< V; i++) adjT.add(new ArrayList<Integer>());
        for (int i=0; i<V; i++){
            vis[i]=false;
            for (Integer it : adj.get(i)){
                adjT.get(it).add(i);
            }
        }

        int count=0;
        while (!st.isEmpty()){
            int node = st.pop();
            if (!vis[node]){
                count++;
                dfs(node, vis, adjT);
            }
        }
        return count;
    }

    private void dfs(int node, boolean[] vis, ArrayList<ArrayList<Integer>> adjT) {
        vis[node]=true;
        for (Integer it : adjT.get(node)){
            if (!vis[it]){
                dfs(it, vis, adjT);
            }
        }
    }

    private void sortInFinishingTime(int node, boolean[] vis, ArrayList<ArrayList<Integer>> adj, Stack<Integer> st) {
        vis[node]=true;
        for (Integer it : adj.get(node)){
            if (!vis[it]){
                sortInFinishingTime(it, vis, adj, st);
            }
        }
        st.push(node);
    }
}
