package BinarySearchTrees.TwoSumBST;

import java.util.Stack;

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

    static class BSTIterator{
        Stack<TreeNode> st= new Stack<>();
        boolean reverse= true;

        public BSTIterator(TreeNode root, boolean isReverse){
            reverse = isReverse;
            pushAll(root);
        }

        public int next(){
            TreeNode node= st.pop();
            if (!reverse) pushAll(node.right);
            else pushAll(node.left);
            return node.val;
        }

        private void pushAll(TreeNode node) {
            while (node!=null){
                st.push(node);
                if (!reverse) node = node.left;
                else node = node.right;
            }
        }
    }
    public boolean findTarget(TreeNode root, int k){
        if (root==null) return false;
        BSTIterator left = new BSTIterator(root, false);
        BSTIterator right = new BSTIterator(root, true);

        int i = left.next();    //finding next()
        int j = right.next();   //finding previous()

        while (i<j){
            if (i+j==k) return true;
            if (i+j < k) i = left.next();
            else j= right.next();
        }
        return false;
    }
}
