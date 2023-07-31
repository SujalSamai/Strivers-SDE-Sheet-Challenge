package BinaryTrees.ZigZagTraversal;

import java.util.*;

public class Code {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) {
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root){
        Queue<TreeNode> queue= new LinkedList<>();
        List<List<Integer>> list= new ArrayList<>();
        if (root==null) return list;

        queue.add(root);
        int level=1;
        while (!queue.isEmpty()){
            int size= queue.size();
            List<Integer> sublist= new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                sublist.add(node.val);
                if (node.left!=null){
                    queue.add(node.left);
                }
                if (node.right!=null){
                    queue.add(node.right);
                }
            }
            if (level%2==0) Collections.reverse(sublist);
            list.add(sublist);
            level++;
        }
        return list;
    }
}
