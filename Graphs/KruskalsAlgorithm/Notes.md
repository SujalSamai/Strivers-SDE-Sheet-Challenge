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
- We will solve this algorithm using Disjoint Sets which provides two methods named findUPar()(This function helps to find the ultimate parent of a particular node) and Union(This basically helps to add the edges between two nodes).
- First, we need to extract the edge information(if not given already) from the given adjacency list in the format of (wt, u, v) where u is the current node, v is the adjacent node and wt is the weight of the edge between node u and v and we will store the tuples in an arraylist.
- Then the array must be sorted in the ascending order of the weights so that while iterating we can get the edges with the minimum weights first.
- After that, we will iterate over the edge information, and for each tuple, we will apply the  following operation:
  - First, we will take the two nodes u and v from the tuple and check if the ultimate parents of both nodes are the same or not using the findUPar() function provided by the Disjoint Set data structure. 
  - If the ultimate parents are the same, we need not do anything to that edge as there already exists a path between the nodes and we will continue to the next tuple. 
  - If the ultimate parents are different, we will add the weight of the edge to our final answer(i.e. mstWt variable used in the following code) and apply the union operation(i.e. either unionBySize(u, v) or unionByRank(u, v)) with the nodes u and v. The union operation is also provided by the Disjoint Set. 
- Finally, we will get our answer (in the mstWt variable as used in the following code) successfully.

### Code
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

### Other Techniques
- NA

### Complexity
1. Time Complexity - O(ElogV)
2. Space Complexity - O(N+E)