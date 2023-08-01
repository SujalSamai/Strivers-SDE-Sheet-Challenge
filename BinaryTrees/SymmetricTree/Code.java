package BinaryTrees.SymmetricTree;

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
    public static boolean isSymmetric(TreeNode root){
        return root==null || isSymmetricalHelp(root.left, root.right);
    }

    private static boolean isSymmetricalHelp(TreeNode left, TreeNode right) {
        if (left==null || right==null) return left==right;
        if (left.val!=right.val) return false;
        return isSymmetricalHelp(left.left, right.right) && isSymmetricalHelp(left.right, right.left);
    }

}