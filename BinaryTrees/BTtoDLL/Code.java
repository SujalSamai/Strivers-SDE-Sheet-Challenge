package BinaryTrees.BTtoDLL;

public class Code {
    static class BinaryTreeNode<T> {
        T data;
        BinaryTreeNode<T> left;
        BinaryTreeNode<T> right;

        public BinaryTreeNode(T data) {
            this.data = data;
        }
    }

    static BinaryTreeNode<Integer> head;
    static BinaryTreeNode<Integer> prev;
    public static BinaryTreeNode<Integer> BTtoDLL(BinaryTreeNode<Integer> root) {
        head=null;
        prev=null;
        helper(root);
        return head;
    }

    private static void helper(BinaryTreeNode<Integer> root) {
        if (root==null) return;
        helper(root.left);
        if (prev==null) head=root;
        else{
            prev.right=root;
            root.left=prev;
        }
        prev=root;
        helper(root.right);
    }
}
