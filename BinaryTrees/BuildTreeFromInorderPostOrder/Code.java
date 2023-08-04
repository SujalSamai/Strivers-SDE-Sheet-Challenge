package BinaryTrees.BuildTreeFromInorderPostOrder;

import java.util.HashMap;

public class Code {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) {
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static TreeNode buildTree(int[] inorder, int[] postorder){
        if (inorder == null || postorder == null || inorder.length != postorder.length) return null;
        HashMap<Integer, Integer> map= new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i],i);
        }

        return buildTreeRoot(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1, map);
    }

    private static TreeNode buildTreeRoot(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd, HashMap<Integer, Integer> map) {
        if (postStart>postEnd || inStart>inEnd) return null;
        TreeNode root= new TreeNode(postorder[postEnd]);
        int inRoot= map.get(root.val);
        int numsLeft= inRoot - inStart;

        root.left= buildTreeRoot(inorder, inStart, inRoot-1, postorder, postStart, postStart+numsLeft-1, map);
        root.right= buildTreeRoot(inorder, inRoot+1, inEnd, postorder, postStart+numsLeft, postEnd-1, map);
        return root;
    }
}
