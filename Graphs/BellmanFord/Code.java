package Graphs.BellmanFord;

import java.util.ArrayList;
import java.util.Arrays;

public class Code {
    static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> edges, int S) {
        int[] dist= new int[V];
        Arrays.fill(dist, (int)1e8);
        dist[S]=0;

        for (int i=0; i<V-1; i++){
            for (ArrayList<Integer> it: edges){
                int u= it.get(0);
                int v= it.get(1);
                int wt= it.get(2);
                if (dist[u] != 1e8 && dist[u]+wt < dist[v]){
                    dist[v]= dist[u]+wt;
                }
            }
        }

        //Nth relaxation to check negative cycle, i.e. if relaxation is happening even after v-1 times,
        //then just return an array consisting of -1
        for (ArrayList<Integer> it:edges){
            int u= it.get(0);
            int v= it.get(1);
            int wt= it.get(2);
            if (dist[u]!=1e8 && dist[u]+wt <dist[v]){
                return new int[]{-1};
            }
        }
        return dist;
    }
}
