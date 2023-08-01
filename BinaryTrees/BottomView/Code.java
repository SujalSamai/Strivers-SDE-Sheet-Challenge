package BinaryTrees.BottomView;

import java.util.*;

public class Code {
    static class Node {
        int data;
        int hd;
        Node left, right;

        public Node(int key) {
            data = key;
            hd = Integer.MAX_VALUE;
            left = right = null;
        }
    }
    public static ArrayList<Integer> bottomView(Node root) {
        ArrayList<Integer> ans= new ArrayList<>();
        TreeMap<Integer, Integer> map= new TreeMap<>();
        Queue<Node> q = new LinkedList<>();
        if (root==null) return ans;
        root.hd=0;
        q.add(root);
        while (!q.isEmpty()){
            Node temp= q.poll();
            int hd= temp.hd;
            map.put(hd, temp.data);
            if (temp.left!=null){
                temp.left.hd= hd-1;
                q.add(temp.left);
            }
            if (temp.right!=null){
                temp.right.hd=hd+1;
                q.add(temp.right);
            }
        }

        for (Map.Entry<Integer, Integer> entry: map.entrySet()){
            ans.add(entry.getValue());
        }
        return ans;
    }
}
