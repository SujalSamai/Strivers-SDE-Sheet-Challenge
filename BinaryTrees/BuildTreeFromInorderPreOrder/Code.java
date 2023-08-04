package BinaryTrees.BuildTreeFromInorderPreOrder;

import java.util.HashMap;
import java.util.Map;

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

    public static TreeNode buildTree(int[] preorder, int[] inorder){
        HashMap<Integer, Integer> map= new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i],i);
        }

        return buildTreeRoot(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1, map);
    }

    private static TreeNode buildTreeRoot(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, HashMap<Integer, Integer> map) {
        if (preStart>preEnd || inStart>inEnd) return null;
        TreeNode root= new TreeNode(preorder[preStart]);
        int inRoot= map.get(root.val);
        int numsLeft= inRoot - inStart;

        root.left= buildTreeRoot(preorder, preStart+1, preStart+numsLeft, inorder, inStart, inRoot-1, map);
        root.right= buildTreeRoot(preorder, preStart+numsLeft+1, preEnd, inorder, inRoot+1, inEnd, map);

        return root;
    }
}
