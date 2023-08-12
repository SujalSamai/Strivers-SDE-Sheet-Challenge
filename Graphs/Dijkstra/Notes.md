### Question
- Given a weighted, undirected and connected graph of V vertices and an adjacency list adj where adj[i] is a list of lists containing two integers where the first integer of each list j denotes there is edge between i and j , second integers corresponds to the weight of that  edge . You are given the source vertex S and You to Find the shortest distance of all the vertex's from the source vertex S. You have to return a list of integers denoting shortest distance between each node and Source vertex S. 
- Note: The Graph doesn't contain any negative weight cycle.

### Sample Input
    V = 2, adj [] = {{{1, 9}}, {{0, 9}}}, S = 0
    V = 3, E = 3, adj = {{{1, 1}, {2, 6}}, {{2, 3}, {0, 1}}, {{1, 3}, {0, 6}}}, S = 2

### Sample Output
    0 9
    4 3 0

### About Dijkstra's Algorithm
- Dijkstra's algorithm is used for finding the shortest path to each node from a single source, we can use a Priority Queue or a Set to implement it

### Solution
- We would be using a min-heap for storing the distance-node pairs, and a source node and a distance array of size V (where ‘V’ are the number of nodes in the graph) initialized with infinity (indicating that at present none of the nodes are reachable from the source node) and initialize the distance to source node as 0. 
- We push the source node to the queue along with its distance which is also 0. 
- For every node at the top of the queue, we pop the element out and look out for its adjacent nodes. If the current reachable distance is better than the previous distance indicated by the distance array (dis + edW < dist[adjNode]), we update the distance and push it into the queue. 
- A node with a lower distance would be at the top of the priority queue as opposed to a node with a higher distance because we are using a min-heap. By following step 3, until our queue becomes empty, we would get the minimum distance from the source node to all other nodes. We can then return the distance array.

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
- Using Hashset

### Complexity
1. Time Complexity - O(E*logV)
2. Space Complexity - O(E + V)