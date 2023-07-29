package BinaryTrees.Inorder;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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

    //In i.e., root will be in the middle -> left, root, right
    //Time - O(N), Space - O(N)
    public List<Integer> inorderTraversal(TreeNode root){
        List<Integer> res= new ArrayList<>();
        getInorderTraversal(root, res);
        return res;
    }

    private void getInorderTraversal(TreeNode root, List<Integer> res) {
        if (root==null) return;

        getInorderTraversal(root.left, res);
        res.add(root.val);
        getInorderTraversal(root.right, res);
    }

    //Iterative Solution - O(N) & O(N)
    /*
        We will use a stack and Node pointing to root
        We will run a loop, and if node is not null, we keep on going to left & push elements to stack
        Once we encounter a null, we pop from stack, and add the value to our res
        Then we move to right side & repeat the process till the stack is empty
     */
    public List<Integer> inorder(TreeNode root){
        List<Integer> res= new ArrayList<>();
        Stack<TreeNode> stack= new Stack<>();
        TreeNode node=root;
        while (true){
            if (node!=null){
                stack.push(node);
                node= node.left;
            }else{
                if (stack.isEmpty()){
                    break;
                }
                node= stack.pop();
                res.add(node.val);
                node=node.right;
            }
        }
        return res;
    }
}
