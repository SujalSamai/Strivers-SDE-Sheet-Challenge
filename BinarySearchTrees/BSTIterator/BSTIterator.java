package BinarySearchTrees.BSTIterator;

import java.util.Stack;

public class BSTIterator {
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

    private Stack<TreeNode> stack = new Stack<>();

    public BSTIterator(TreeNode root){
        pushAll(root);
    }

    public int next() {
        TreeNode temp = stack.pop();
        if (temp.right!=null){
            pushAll(temp.right);
        }
        return temp.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    private void pushAll(TreeNode root) {
        while (root!=null){
            stack.push(root);
            root= root.left;
        }
    }
}
