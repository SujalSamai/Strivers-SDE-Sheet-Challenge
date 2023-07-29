package BinaryTrees.PreOrder;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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

    //Pre i.e., root will be at beginning -> root, left, right
    //Time - O(N), Space - O(N)
    public List<Integer> preorderTraversal(TreeNode root){
        List<Integer> res = new ArrayList<>();
        getPreOrderTraversal(root, res);
        return res;
    }

    private void getPreOrderTraversal(TreeNode root, List<Integer> res) {
        if (root==null) return;

        res.add(root.val);
        getPreOrderTraversal(root.left, res);
        getPreOrderTraversal(root.right, res);
    }


    //Iterative - O(N) & O(N)
    /*
        We will use a stack & initially push root into it
        Till stack is not empty, we will pop the root & add its value to our res
        then if root has right node, push into stack
        then if root has left node, push into stack
        (Note: we are pushing right first, as we are using a Stack which is LIFO ds)
    */
    public List<Integer> preOrder(TreeNode root){
        List<Integer> res= new ArrayList<>();
        if (root==null) return res;
        Stack<TreeNode> st= new Stack<>();
        st.push(root);
        while (!st.isEmpty()){
            root=st.pop();
            res.add(root.val);
            if (root.right!=null) st.push(root.right);
            if (root.left!=null) st.push(root.left);
        }
        return res;
    }
}
