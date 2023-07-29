package BinaryTrees.PostOrder;

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

    //Post i.e., root will be at last -> left, right, root
    //Time - O(N), Space - O(N)
    public List<Integer> postorderTraversal(TreeNode root){
        List<Integer> res= new ArrayList<>();
        getPostorderTraversal(root, res);
        return res;
    }

    private void getPostorderTraversal(TreeNode root, List<Integer> res) {
        if (root==null) return;

        getPostorderTraversal(root.left, res);
        getPostorderTraversal(root.right, res);
        res.add(root.val);
    }

    //Iterative Solution - O(N) & O(N)
    public List<Integer> postOrder(TreeNode root){
        List<Integer> res= new ArrayList<>();
        if (root==null) return res;
        Stack<TreeNode> st= new Stack<>();
        while (root!=null || !st.isEmpty()){
            if (root!=null){
                st.push(root);
                root=root.left;
            }else{
                TreeNode temp= st.peek().right;
                if (temp==null){
                    temp= st.peek();
                    st.pop();
                    res.add(temp.val);
                    while (!st.isEmpty() && temp==st.peek().right){
                        temp=st.peek();
                        st.pop();
                        res.add(temp.val);
                    }
                }else{
                    root=temp;
                }
            }
        }
        return res;
    }
}
