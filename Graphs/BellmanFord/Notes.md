### Question
- Given a weighted, directed and connected graph of V vertices and E edges, Find the shortest distance of all the vertex's from the source vertex S. 
- Note: If the Graph contains a negative cycle then return an array consisting of only -1.

### Sample Input
    V = 2, E = [[0,1,9]], S = 0
    V = 3, E = [[0,1,5],[1,0,3],[1,2,-1],[2,0,1]], S = 2

### Sample Output
    0 9
    1 6 0

### About Bellman Ford's Algorithm
- The bellman-Ford algorithm helps to find the shortest distance from the source node to all other nodes. But, we have already learned Dijkstra’s algorithm (Dijkstra’s algorithm article link) to fulfill the same purpose. Now, the question is how this algorithm is different from Dijkstra’s algorithm.
- While learning Dijkstra’s algorithm, we came across the following two situations, where Dijkstra’s algorithm failed:
  - If the graph contains negative edges. 
  - If the graph has a negative cycle (In this case Dijkstra’s algorithm fails to minimize the distance, keeps on running, and goes into an infinite loop. As a result it gives TLE error).
- Negative Cycle: A cycle is called a negative cycle if the sum of all its weights becomes negative.
- Bellman-Ford’s algorithm successfully solves these problems. It works fine with negative edges as well as it is able to detect if the graph contains a negative cycle. But this algorithm is only applicable for directed graphs. 
- In order to apply this algorithm to an undirected graph, we just need to convert the undirected edges into directed edges
- In this algorithm, the edges can be given in any order. The intuition is to relax all the edges for N-1( N = no. of nodes) times sequentially. After N-1 iterations, we should have minimized the distance to every node.
- Points to remember since, in a graph of N nodes we will take at most N-1 edges to reach from the first to the last node, we need exact N-1 iterations. It is impossible to draw a graph that takes more than N-1 edges to reach any node.
- We know if we keep on rotating inside a negative cycle, the path weight will be decreased in every iteration. But according to our intuition, we should have minimized all the distances within N-1 iterations(that means, after N-1 iterations no relaxation of edges is possible).
  In order to check the existence of a negative cycle, we will relax the edges one more time after the completion of N-1 iterations. And if in that Nth iteration, it is found that further relaxation of any edge is possible, we can conclude that the graph has a negative cycle. Thus, the Bellman-Ford algorithm detects negative cycles.

### Solution
- First, we will initialize the source node in the distance array to 0 and the rest of the nodes to infinity. 
- Then we will run a loop for N-1 times. 
- Inside that loop, we will try to relax every given edge. For example, one of the given edge information is like (u, v, wt), where u = starting node of the edge, v = ending node, and wt = edge weight. For all edges like this we will be checking if node u is reachable and if the distance to reach v through u is less than the distance to v found until now(i.e. dist[u] and dist[u]+ wt < dist[v]). 
- After repeating the 3rd step for N-1 times, we will apply the same step one more time to check if the negative cycle exists. If we found further relaxation is possible, we will conclude the graph has a negative cycle and from this step, we will return a distance array of -1(i.e. minimization of distances is not possible). 
- Otherwise, we will return the distance array which contains all the minimized distances.

### Code
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

### Other Techniques
- NA

### Complexity
1. Time Complexity - O(E*V)
2. Space Complexity - O(V)