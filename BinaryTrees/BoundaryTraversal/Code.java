package BinaryTrees.BoundaryTraversal;

import java.util.ArrayList;
import java.util.Stack;

public class Code {
    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static ArrayList<Integer> traverseBoundary(TreeNode root){
        ArrayList<Integer> ans= new ArrayList<>();
        if (!isLeaf(root)) ans.add(root.data);
        leftTraversal(root,ans);
        leafInorder(root,ans);
        rightTraversal(root,ans);
        return ans;
    }

    private static void rightTraversal(TreeNode root, ArrayList<Integer> ans) {
        TreeNode cur= root.right;
        Stack<Integer> st= new Stack<>();
        while (cur!=null){
            if (!isLeaf(cur)) st.push(cur.data);
            if (cur.right==null) cur= cur.left;
            else cur= cur.right;
        }
        while (!st.isEmpty()){
            ans.add(st.pop());
        }
    }

    private static void leafInorder(TreeNode root, ArrayList<Integer> ans) {
        if (isLeaf(root)){
            ans.add(root.data);
            return;
        }
        if (root.left!=null) leafInorder(root.left, ans);
        if (root.right!=null) leafInorder(root.right, ans);
    }

    private static void leftTraversal(TreeNode root, ArrayList<Integer> ans) {
        TreeNode cur= root.left;
        while (cur!=null){
            if (!isLeaf(cur)) ans.add(cur.data);
            if (cur.left==null) cur= cur.right;
            else cur= cur.left;
        }
    }

    private static boolean isLeaf(TreeNode root) {
        return root!=null && root.left==null && root.right==null;
    }
}
