package BinarySearchTrees.Insertion;

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

    public static TreeNode insertIntoBST(TreeNode root, int val){
        if (root==null) return new TreeNode(val);
        TreeNode cur= root;
        while (true){
            if (cur.val<=val){
                if (cur.right!= null) cur= cur.right;
                else{
                    cur.right= new TreeNode(val);
                    break;
                }
            }else{
                if (cur.left!=null) cur=cur.left;
                else{
                    cur.left= new TreeNode(val);
                    break;
                }
            }
        }
        return root;
    }
}
