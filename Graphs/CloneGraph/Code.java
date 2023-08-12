package Graphs.CloneGraph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Code {
    static class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

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
}
