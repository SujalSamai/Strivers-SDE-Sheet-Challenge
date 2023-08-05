package BinarySearchTrees.SearchBST;

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

    public static TreeNode searchBST(TreeNode root, int val){
        while (root!= null && root.val!=val){
            if (val < root.val){
                root= root.left;
            }else{
                root = root.right;
            }
        }
        return root;
    }
}
