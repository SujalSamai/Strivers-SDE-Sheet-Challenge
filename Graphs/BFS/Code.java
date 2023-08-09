package Graphs.BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Code {
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj){
        ArrayList<Integer> res= new ArrayList<>();
        Queue<Integer> q= new LinkedList<>();
        boolean[] vis= new boolean[V];

        q.add(0);
        vis[0]=true;

        while (!q.isEmpty()){
            Integer node=q.poll();
            res.add(node);
            for (Integer it : adj.get(node)) {
                if (!vis[it]){
                    vis[it]=true;
                    q.add(it);
                }
            }
        }
        return res;
    }
}
