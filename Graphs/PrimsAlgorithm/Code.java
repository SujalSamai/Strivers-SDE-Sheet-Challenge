package Graphs.PrimsAlgorithm;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Code {
    static class Pair{
        int wt, node;
        public Pair(int node, int wt){
            this.node=node;
            this.wt=wt;
        }
    }
    static int spanningTree(int V, int E, int edges[][]){
        ArrayList<ArrayList<Pair>>adj=new ArrayList<>();
        //Creating an adjacency list
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }

        //the matrix is given in form of (Parent, neighbour, weight) & is an undirected graph
        //so we will, add the neighbour & weight for each node in our adjacency list
        //suppose we have an edge between 0 & 1, having weight 2
        for(int i=0;i<E;i++){
            adj.get(edges[i][0]).add(new Pair(edges[i][1],edges[i][2]));       //stores 0-> (1,2)
            adj.get(edges[i][1]).add(new Pair(edges[i][0],edges[i][2]));       //stores 1-> (0,2)
        }
        //Adjacency list format -> [(n,w),(n,w)....]

        PriorityQueue<Pair> pq= new PriorityQueue<>((x,y)->x.wt-y.wt);  //creates a min-heap sorted acc to weight
        boolean[] vis= new boolean[V];
        pq.add(new Pair(0,0));
        int sum=0;
        while (!pq.isEmpty()){
            int wt= pq.peek().wt;
            int node = pq.peek().node;
            pq.remove();

            if (vis[node]) continue;    //if the node is visited already, skip it
            vis[node]=true;             //else make it visited & add to sum
            sum+=wt;

            for (Pair p : adj.get(node)){
                if (!vis[p.node]){
                    pq.add(p);
                }
            }
        }
        return sum;
    }
}
