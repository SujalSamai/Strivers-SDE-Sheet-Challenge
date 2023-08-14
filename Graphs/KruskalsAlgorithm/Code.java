package Graphs.KruskalsAlgorithm;

import DisjointSet.DisjointSet;

import java.util.ArrayList;
import java.util.Collections;

public class Code {
    static class Triplet implements Comparable<Triplet>{
        int src, dest, wt;
        public Triplet(int src, int dest, int wt){
            this.src=src;
            this.dest=dest;
            this.wt=wt;
        }

        @Override
        public int compareTo(Triplet compareEdge) {
            return this.wt - compareEdge.wt;
        }
    }
    static int spanningTree(int V, int E, int edges[][]){
        ArrayList<Triplet> adj = new ArrayList<Triplet>();
        for (int[] edge : edges){
            int u=edge[0];
            int v=edge[1];
            int wt= edge[2];
            adj.add(new Triplet(u,v,wt));
        }

        Collections.sort(adj);
        DisjointSet ds = new DisjointSet(V);
        int minWt=0;
        for (Triplet it : adj){
            int u= it.src;
            int v= it.dest;
            int wt= it.wt;
            if (ds.findPar(u) != ds.findPar(v)){
                minWt += wt;
                ds.unionBySize(u,v);
            }
        }
        return minWt;
    }
}
