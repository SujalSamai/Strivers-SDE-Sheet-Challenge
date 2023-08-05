package BinarySearchTrees.ConstructBSTPreorder;

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

    public static TreeNode bstFromPreorder(int[] preorder){
        return bstFromPreorderHelper(preorder, Integer.MAX_VALUE, new int[]{0});
    }

    private static TreeNode bstFromPreorderHelper(int[] preorder, int bound, int[] i) {
        if (i[0]== preorder.length || preorder[i[0]] > bound) return null;
        TreeNode root= new TreeNode(preorder[i[0]++]);
        root.left = bstFromPreorderHelper(preorder, root.val, i);
        root.right = bstFromPreorderHelper(preorder, bound, i);
        return root;
    }
}
