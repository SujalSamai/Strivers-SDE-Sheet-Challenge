package Graphs.UndirectedCycleBFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Code {
    static class Pair{
        int first, second;
        public Pair(int first, int second){
            this.first=first;
            this.second=second;
        }
    }
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis= new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!vis[i]){
                if (checkForCycle(adj, i, vis)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkForCycle(ArrayList<ArrayList<Integer>> adj, int el, boolean[] vis) {
        Queue<Pair> q= new LinkedList<>();
        q.add(new Pair(el, 1));
        vis[el]=true;

        while (!q.isEmpty()){
            int node = q.peek().first;
            int parent= q.peek().second;
            q.remove();

            for (Integer it: adj.get(node)){
                if (!vis[it]){
                    q.add(new Pair(it, node));
                    vis[it]=true;
                }
                else if (parent!=it){
                    return true;
                }
            }
        }
        return false;
    }
}
