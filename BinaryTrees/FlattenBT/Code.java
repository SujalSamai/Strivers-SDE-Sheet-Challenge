package BinaryTrees.FlattenBT;

import java.util.Stack;

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

    static TreeNode prev= null;
    public void flatten(TreeNode root) {
        Stack<TreeNode> st= new Stack<>();
        if (root==null) return;
        st.push(root);
        while (!st.isEmpty()){
            TreeNode cur= st.pop();
            if (cur.right!=null)  st.push(cur.right);
            if (cur.left!=null)   st.push(cur.left);

            if (!st.isEmpty()){
                cur.right=st.peek();
            }
            cur.left=null;
        }
    }


    //Morris Traversal
    public void flattenMorris(TreeNode root){
        TreeNode cur=root;
        while (cur!=null){
            if (cur.left!=null){
                TreeNode pre= cur.left;
                while (pre.right!=null) pre= pre.right;
                pre.right = cur.right;
                cur.right=cur.left;
                cur.left=null;
            }
            cur=cur.right;
        }
    }
}
