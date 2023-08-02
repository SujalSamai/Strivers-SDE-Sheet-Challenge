package BinaryTrees.MaxWidth;

import java.util.LinkedList;
import java.util.Queue;

public class Code {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    static class Pair{
        TreeNode node;
        int num;
        Pair(TreeNode node, int num){
            this.node= node;
            this.num= num;
        }
    }

    public static int widthOfBinaryTree(TreeNode root){
        if (root==null) return 0;
        Queue<Pair> q= new LinkedList<>();
        int ans=0;
        q.add(new Pair(root, 0));
        while (!q.isEmpty()){
            int size= q.size();
            int mini= q.peek().num;
            int first=0, last=0;
            for (int i = 0; i < size; i++) {
                int cur = q.peek().num - mini;
                TreeNode node= q.poll().node;
                if (i==0) first= cur;
                if (i== size-1) last = cur;
                if (node.left!=null){
                    q.add(new Pair(node.left, cur*2+1));
                }
                if (node.right!=null){
                    q.add(new Pair(node.right, cur*2+2));
                }
            }
            ans= Math.max(ans, last-first+1);
        }
        return ans;
    }
}
