package BinaryTrees.MorrisPreorder;

import java.util.ArrayList;
import java.util.List;

public class Code {
    static class TreeNode{
        int val;
        TreeNode left, right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static List<Integer> preorderTraversal(TreeNode root){
        List<Integer> preorder= new ArrayList<>();
        TreeNode cur= root;
        while (cur!=null){
            if (cur.left==null){
                preorder.add(cur.val);
                cur= cur.right;
            }else{
                TreeNode prev=cur.left;
                while (prev.right!=null && prev.right!=cur){
                    prev=prev.right;
                }

                if (prev.right==null){
                    prev.right=cur;
                    preorder.add(cur.val);
                    cur=cur.left;
                }else{
                    prev.right=null;
                    cur=cur.right;
                }
            }
        }
        return preorder;
    }
}
