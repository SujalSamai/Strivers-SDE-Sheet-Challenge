package BinarySearchTrees.MaxSumBST;

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

    static class NodeValue{
        public int maxSum, minVal, maxVal;
        public NodeValue(int max, int min, int maxSum){
            this.maxSum= maxSum;
            this.minVal=min;
            this.maxVal= max;
        }
    }

    int max=0;
    public int maxSumBST(TreeNode root){
        maxSumBSTHelper(root);
        return max;
    }

    private NodeValue maxSumBSTHelper(TreeNode root) {
        if (root==null){
            return new NodeValue(Integer.MIN_VALUE, Integer.MAX_VALUE, 0);
        }
        NodeValue l= maxSumBSTHelper(root.left);
        NodeValue r = maxSumBSTHelper(root.right);

        if (l.maxVal < root.val && root.val < r.minVal){
            max = Math.max(max, root.val+l.maxSum+r.maxSum);
            return new NodeValue(Math.max(root.val, r.maxVal), Math.min(root.val, l.minVal), root.val+l.maxSum + r.maxSum);
        }

        return new NodeValue(Integer.MAX_VALUE, Integer.MIN_VALUE, Math.max(l.maxSum, r.maxSum));
    }
}
