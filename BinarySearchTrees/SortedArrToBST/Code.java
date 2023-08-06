package BinarySearchTrees.SortedArrToBST;

import BinarySearchTrees.BSTIterator.BSTIterator;

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

    public static TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length==0) return null;
        return createBST(nums, 0, nums.length-1);
    }

    private static TreeNode createBST(int[] nums, int l, int r) {
        if (l>r) return null;

        int mid = l + (r - l) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = createBST(nums, l, mid-1);
        root.right = createBST(nums, mid+1, r);
        return root;
    }
}
