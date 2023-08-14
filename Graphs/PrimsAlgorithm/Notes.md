### Question
- Given a weighted, undirected and connected graph of V vertices and E edges. The task is to find the sum of weights of the edges of the Minimum Spanning Tree.

### Sample Input
    3 3
    0 1 5
    1 2 3
    0 2 1

### Sample Output
    4

### Solution
- In order to implement Prim’s algorithm, we will be requiring an array(visited array) and a priority queue that will essentially represent a min-heap. We need another array(MST) as well if we wish to store the edge information of the minimum spanning tree.
- The priority queue will be storing the pairs (node, edge weight). We can start from any given node. Here we are going to start from node 0 and so we will initialize the priority queue with (0, 0). If we wish to store the mst of the graph, the priority queue should instead store the triplets (edge weight, adjacent node, parent node) and in that case, we will initialize with (0, 0, -1).
- We will first push edge weight 0, node value 0, and parent -1 as a triplet into the priority queue to start the algorithm.
  Note: We can start from any node of our choice. Here we have chosen node 0.
- Then the top-most element (element with minimum edge weight as it is the min-heap we are using) of the priority queue is popped out.
- After that, we will check whether the popped-out node is visited or not.
    - If the node is visited: We will continue to the next element of the priority queue.
    - If the node is not visited: We will mark the node visited in the visited array and add the edge weight to the sum variable. If we wish to store the mst, we should insert the parent node and the current node into the mst array as a pair in this step.
- Now, we will iterate on all the unvisited adjacent nodes of the current node and will store each of their information in the specified triplet format i.e. (edge weight, node value, and parent node) in the priority queue.
- We will repeat steps 2, 3, and 4 using a loop until the priority queue becomes empty.
- Finally, the sum variable should store the sum of all the edge weights of the minimum spanning tree.

### Intuition
The intuition of this algorithm is the greedy technique used for every node. If we carefully observe, for every node, we are greedily selecting its unvisited adjacent node with the minimum edge weight(as the priority queue here is a min-heap and the topmost element is the node with the minimum edge weight). Doing so for every node, we can get the sum of all the edge weights of the minimum spanning tree and the spanning tree itself(if we wish to) as well.

### Code
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

### Other Techniques
- NA

### Complexity
1. Time Complexity - O(ElogE)
2. Space Complexity - O(V+E)