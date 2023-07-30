package BinaryTrees.BalancedBT;

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

    //balanced tree=> for every node, height(left) - height(right) <= 1
    public static boolean isBalanced(TreeNode root){
        return dfsHeight(root) != -1;
    }

    private static int dfsHeight(TreeNode root) {
        if (root==null) return 0;

        int left= dfsHeight(root.left);
        if (left==-1) return -1;
        int right= dfsHeight(root.right);
        if (right==-1) return -1;

        if (Math.abs(left-right)>1) return -1;
        return Math.max(left, right)+1;
    }
}
