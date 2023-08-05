package BinarySearchTrees.KthSmallestBST;

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

    public int kthSmallest(TreeNode root, int k){
        int[] res= {0, -1};     // res[0]= count, res[1]=result
        inorder(root, k, res);
        return res[1];
    }

    private void inorder(TreeNode root, int k, int[] res) {
        if (root==null) return;

        inorder(root.left, k, res);
        res[0]= res[0]+1;   //count++

        if (res[0]==k){     //count==k, return result
            res[1]=root.val;
            return;
        }

        inorder(root.right, k, res);
    }
}
