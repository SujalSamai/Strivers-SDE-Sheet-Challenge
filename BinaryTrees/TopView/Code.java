package BinaryTrees.TopView;

import java.util.*;

public class Code {
    static class BinaryTreeNode {
        int val;
        BinaryTreeNode left;
        BinaryTreeNode right;

        BinaryTreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    static class Pair{
        int hd;
        BinaryTreeNode node;
        Pair(BinaryTreeNode node, int hd){
            this.hd=hd;
            this.node= node;
        }
    }

    public static ArrayList<Integer> getTopView(BinaryTreeNode root) {
        ArrayList<Integer> ans= new ArrayList<>();
        if (root==null) return ans;
        Map<Integer, Integer> map= new TreeMap<>();
        Queue<Pair> q= new LinkedList<>();
        q.add(new Pair(root, 0));
        while (!q.isEmpty()){
            Pair it = q.poll();
            int hd= it.hd;
            BinaryTreeNode temp= it.node;
            if (!map.containsKey(hd)) map.put(hd, temp.val);
            if (temp.left!=null){
                q.add(new Pair(temp.left, hd-1));
            }
            if (temp.right!=null){
                q.add(new Pair(temp.right, hd+1));
            }
        }

        for (Map.Entry<Integer,Integer> entry: map.entrySet()){
            ans.add(entry.getValue());
        }
        return ans;
    }
}
