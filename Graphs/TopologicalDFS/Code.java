package Graphs.TopologicalDFS;

import java.util.ArrayList;
import java.util.Stack;

public class Code {
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] visited= new int[V];
        Stack<Integer> st= new Stack<>();
        for (int i = 0; i < V; i++) {
            if (visited[i]==0){
                topoDFS(i, visited, adj, st);
            }
        }

        int[] topo= new int[V];
        int ind=0;
        while (!st.isEmpty()){
            topo[ind++]=st.pop();
        }
        return topo;
    }

    private static void topoDFS(int node, int[] visited, ArrayList<ArrayList<Integer>> adj, Stack<Integer> st) {
        visited[node]=1;
        for (Integer it : adj.get(node)){
            if (visited[it]==0){
                topoDFS(it, visited, adj, st);
            }
        }
        st.push(node);
    }
}
