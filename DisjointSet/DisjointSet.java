package DisjointSet;

import java.util.ArrayList;
import java.util.List;

public class DisjointSet {
    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();

    public DisjointSet(int n){
        for (int i = 0; i <=n; i++) {
            rank.add(0);
            parent.add(i);
            size.add(1);
        }
    }

    public int findPar(int node){
        if (node == parent.get(node)) return node;  //if the parent of node is, it itself
        int ultimatePar = findPar(parent.get(node));    //recursively find the ultimate parent
        parent.set(node, ultimatePar);      //set the ultimate parent of the node in the parent list & return it
        return parent.get(node);
    }

    public void unionByRank(int u, int v){
        int ultPar_u = findPar(u);
        int ultPar_v = findPar(v);
        if (ultPar_u==ultPar_v) return; //if both of them has same ultimate parent then they are already joined
        if (rank.get(ultPar_u) < rank.get(ultPar_v)){
            parent.set(ultPar_u, ultPar_v);     //if rank of u's parent is < v's parent then set u's parent as v's
        }
        else if (rank.get(ultPar_u) > rank.get(ultPar_v)){
            parent.set(ultPar_v, ultPar_u);
        }
        else{
            parent.set(ultPar_v, ultPar_u);     //if both parents have same rank, then join any one with the other
            int rankU = rank.get(ultPar_u);
            rank.set(ultPar_u, rankU+1);        //get the rank of the new parent & update it by 1
        }
    }

    public void unionBySize(int u, int v){
        int ultPar_u = findPar(u);
        int ultPar_v = findPar(v);
        if (ultPar_u==ultPar_v) return;
        if (size.get(ultPar_u) < size.get(ultPar_v)){
            parent.set(ultPar_u, ultPar_v);
            size.set(ultPar_v, size.get(ultPar_u) + size.get(ultPar_v));
        }else{
            parent.set(ultPar_v, ultPar_u);
            size.set(ultPar_u, size.get(ultPar_u) + size.get(ultPar_v));
        }
    }
}
