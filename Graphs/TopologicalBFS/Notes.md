### Question
- Given a Directed Acyclic Graph (DAG) with V vertices and E edges, Find any Topological Sorting of that Graph.

### Sample Input
![img.png](img.png)

### Sample Output
    One of the solutions is 1,2,3,5,4

### Solution
- Topological Sorting means linear ordering of vertices such that there is an edge u—-> v, u appears before v in the ordering. There can be multiple toposorts order for the given graph but the condition should be if there is an edge u->v then u should always appear before v.
- The question states that if there is an edge between u and v then u should appear before v, Which means we have to start this question from a node that doesn’t have any previous edges. But how to find that node that has no edge before if? Here, we use the concept of in-degree (Number of edges pointing toward a node). We find an in-degree which has indegree=0 and we start from this. We use the Indegree concept to find topological sorting.
- In order to maintain the In-degree of each and every node, we take an array of size v( where v is the number of nodes). Find in-degree of all nodes and fill them in an array 
- Now take Queue data structure and add nodes that have in-degree is 0 (as we discussed in the intuition), and simply apply bfs on queue with some condition. 
- Take the top/peek node from Queue ( let the popped node be x), add this x to our answer.
- BFS:
  - Take neighbour nodes of popped nodes and reduce their in-degree by 1. 
  - Check if any of the popped element nodes in degree becomes 0, after reducing in-degree by 1 if it happens then add this neighbour element to the queue for which the in-degree became zero. Repeat step till the queue becomes empty.

### Code
    public int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj){
        int[] topo= new int[V];
        int[] indegree = new int[V];

        for (int i = 0; i < V; i++) {
            for (Integer it :adj.get(i)){
                indegree[it]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (indegree[i]==0){
                q.add(i);
            }
        }

        int ind=0;
        while (!q.isEmpty()){
            Integer node= q.poll();
            topo[ind++]=node;
            for (Integer it : adj.get(node)){
                indegree[it]--;
                if (indegree[it]==0){
                    q.add(it);
                }
            }
        }
        return topo;
    }

### Other Techniques
- NA

### Complexity
1. Time Complexity - O(N+E)
2. Space Complexity - O(2N)