### Question
- Given a Directed Graph with V vertices (Numbered from 0 to V-1) and E edges, check whether it contains any cycle or not.

### Sample Input
    graph = [[1],[2],[3],[3]]
    graph = [[1],[2]]

### Sample Output
    true
    false

### Solution
- We know we can use Topological sort only in directed acyclic graph. So we will use Kahn's algorithm i.e., Topological sort using BFS
- If we can do topological sort that means, the graph is acyclic, but if topological sort fails then graph is cyclic
- We will apply topological sort in our graph, if we can traverse all V nodes then graph is acyclic but if we can't traverse all nodes then it is cyclic
- We will use the same method as Topological sort using BFS, the only change is we don't need an extra array to store the topological sort
- we will take a count variable and increment it each time we poll from queue, this is way of counting how many nodes we have visited
- At the end, if queue is empty and count is not equal to V then that means we couldn't reach every node so the graph must be cyclic

### Code
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj){
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

        int count=0;
        while (!q.isEmpty()){
            Integer node= q.poll();
            count++;
            for (Integer it : adj.get(node)){
                indegree[it]--;
                if (indegree[it]==0){
                    q.add(it);
                }
            }
        }
        return count != V;
    }

### Other Techniques
- NA

### Complexity
1. Time Complexity - O(V+E)
2. Space Complexity - O(2N)