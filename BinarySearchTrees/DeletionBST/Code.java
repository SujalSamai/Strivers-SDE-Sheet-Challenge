package BinarySearchTrees.DeletionBST;

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

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root==null) return null;
        if (root.val==key) return helper(root);

        TreeNode dummy=root;
        while (root!=null){
            if (root.val>key){
                if (root.left!=null && root.left.val==key){
                    root.left = helper(root.left);
                    break;
                }else{
                    root=root.left;
                }
            }else{
                if (root.right!=null && root.right.val==key){
                    root.right = helper(root.right);
                    break;
                }else{
                    root= root.right;
                }
            }
        }
        return dummy;
    }

    private TreeNode helper(TreeNode root) {
        if (root.left==null) return root.right;
        else if (root.right==null) return root.left;
        else{
            TreeNode rightChild = root.right;
            TreeNode lastRight= findLastRight(root.left);
            lastRight.right = rightChild;
            return root.left;
        }
    }

    private TreeNode findLastRight(TreeNode root) {
        if (root.right==null) return root;
        return findLastRight(root.right);
    }
}
