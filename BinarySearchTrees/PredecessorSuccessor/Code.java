package BinarySearchTrees.PredecessorSuccessor;

import java.util.ArrayList;

public class Code {
    static class TreeNode<T> {
        public T data;
        public TreeNode<T> left;
        public TreeNode<T> right;

        TreeNode(T data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    public static ArrayList<Integer> predecessorSuccessor(TreeNode<Integer> root, int key) {
        ArrayList<Integer> ans= new ArrayList<>();
        ans.add(predecessor(root, key));
        ans.add(successor(root,key));
        return ans;
    }

    private static int predecessor(TreeNode<Integer> root, int key) {
        int pre = -1;
        while (root!=null){
            if (key <= root.data){
                root = root.left;
            }else{
                pre = root.data;
                root= root.right;
            }
        }
        return pre;
    }

    private static int successor(TreeNode<Integer> root, int key) {
        int suc = -1;
        while (root!=null){
            if (key >= root.data){
                root= root.right;
            }else{
                suc= root.data;
                root = root.left;
            }
        }
        return suc;
    }
}
