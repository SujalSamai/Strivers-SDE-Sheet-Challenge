package BinaryTrees.LevelOrder;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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

    public List<List<Integer>> levelOrder(TreeNode root){
        Queue<TreeNode> queue= new LinkedList<>();
        List<List<Integer>> res= new ArrayList<List<Integer>>();

        if (root==null) return res;
        queue.add(root);
        while (!queue.isEmpty()){
            int level= queue.size();
            List<Integer> subList = new ArrayList<>();
            for (int i = 0; i < level; i++) {
                if (queue.peek().left!=null){
                    queue.add(queue.peek().left);
                }
                if (queue.peek().right!=null){
                    queue.add(queue.peek().right);
                }
                subList.add(queue.poll().val);
            }
            res.add(subList);
        }
        return res;
    }
}
