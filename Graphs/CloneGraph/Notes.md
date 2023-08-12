### Question
- TGiven a reference of a node in a connected undirected graph. 
- Return a deep copy (clone) of the graph. 
- Each node in the graph contains a value (int) and a list (List[Node]) of its neighbors.
    ```
  class Node {
        public int val;
        public List<Node> neighbors;
    }
  ```

### Sample Input
    adjList = [[2,4],[1,3],[2,4],[1,3]]
    adjList = [[]]

### Sample Output
    [[2,4],[1,3],[2,4],[1,3]]
    [[]]

### Solution
- Here the Node is a pair of an Integer value & an arraylist
- We will use a Hashmap, which will store the value of Node & a Node itself
- Initially we will create a copy of the first node given to us & then we will use DFS
- If the map doesn't contain the current value of the copy node, we will put value of copy and copy node in the map
- Now we will traverse the neighbours of original node
- Create a new node for neighbour if it's not in map already, and add this node to copy.neighbour list
- Recursively call the dfs for original child, copychild

### Code
    public Node cloneGraph(Node node){
        if (node==null) return null;
        HashMap<Integer, Node> map= new HashMap<>();
        Node copy= new Node(node.val);
        cloneGraphDFS(node, copy, map);
        return copy;
    }

    private void cloneGraphDFS(Node original, Node copy, HashMap<Integer, Node> map) {
        if (!map.containsKey(copy.val)){
            map.put(copy.val, copy);
            for (Node ogChild : original.neighbors){
                Node copyChild = map.getOrDefault(ogChild.val, new Node(ogChild.val));
                copy.neighbors.add(copyChild);

                cloneGraphDFS(ogChild, copyChild, map);
            }
        }
    }

### Other Techniques
- NA

### Complexity
1. Time Complexity - O(V+E)
2. Space Complexity - O(V)