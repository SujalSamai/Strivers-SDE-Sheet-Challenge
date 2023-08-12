package Graphs.Dijkstra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Code {
    static class Pair{
        int distance;
        int node;
        public Pair(int distance,int node){
            this.distance = distance;
            this.node = node;
        }
    }
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S) {
        PriorityQueue<Pair> pq= new PriorityQueue<Pair>((x,y)-> x.distance-y.distance);
        int[] dist= new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[S]=0;
        pq.add(new Pair(0, S));

        while (!pq.isEmpty()){
            int dis= pq.peek().distance;
            int node = pq.peek().node;
            pq.remove();

            for (int i = 0; i < adj.get(node).size(); i++) {
                int edgeWgt = adj.get(node).get(i).get(1);
                int adjNode = adj.get(node).get(i).get(0);

                if (dis + edgeWgt < dist[adjNode]){
                    dist[adjNode] = dis+edgeWgt;
                    pq.add(new Pair(dist[adjNode], adjNode));
                }
            }
        }
        return dist;
    }
}
