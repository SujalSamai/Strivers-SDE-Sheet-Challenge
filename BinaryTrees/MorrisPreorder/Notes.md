### Question
- Write a program for Morris Preorder Traversal of a Binary Tree.

### Sample Input
    root = [1,null,2,3]
    root = []

### Sample Output
    [1,2,3]
    []

### Solution
- In Morris Inorder Traversal, we are traversing the tree in the way:- Left, Root, Right. In Morris Preorder traversal we want to traverse the tree in the way:- Root, Left, Right. Therefore, the following code changes are required:
  - When the current node has a left child: In Morris Inorder traversal we would simply make the new thread required and then move the current node to its left. When we return to the original node from the thread we print it. But in Morris preorder traversal, we want to print the root before visiting the left child, therefore after we set the thread, we first print the current node’s value and then move it to its left. 
  - When the current node has no left child: This case remains exactly the same because if there is nothing to visit on the left, we will want to print the current node’s value and move right in both traversals. Therefore, there will be no code modification.
- When we are currently at a node, the following cases can arise:
  - Case 1: When the current node has no left subtree. In this scenario, there is nothing to be traversed on the left side, so we simply print the value of the current node and move to the right of the current node. 
  - Case 2: When there is a left subtree and the right-most child of this left subtree is pointing to null. In this case we need to set the right-most child to point to the current node, instead of NULL, print the current node value and move to the left of the current node. 
  - Case 3: When there is a left subtree and the right-most child of this left-subtree is already pointing to the current node. In this case we know that the left subtree is already visited so we need to reset the last node to NULL and move the current node to its right.
- To summarize, at a node whether we have to move left or right is determined whether the node has a left subtree. If it doesn’t we move to the right. If there is a left subtree then we see its rightmost child. If the rightmost child is pointing to NULL, we print the current node’s value and move it to its left. If the rightmost child is already pointing towards the current node, we remove that link and move to the right of the current node. We will stop the execution when the current points to null and we have traversed the whole tree.

### Code
     public static List<Integer> preorderTraversal(TreeNode root){
        List<Integer> preorder= new ArrayList<>();
        TreeNode cur= root;
        while (cur!=null){
            if (cur.left==null){
                preorder.add(cur.val);
                cur= cur.right;
            }else{
                TreeNode prev=cur.left;
                while (prev.right!=null && prev.right!=cur){
                    prev=prev.right;
                }

                if (prev.right==null){
                    prev.right=cur;
                    preorder.add(cur.val);
                    cur=cur.left;
                }else{
                    prev.right=null;
                    cur=cur.right;
                }
            }
        }
        return preorder;
    }

### Edge Cases
- NA

### Other Techniques
- NA

### Complexity
1. Time Complexity - O(N)
2. Space Complexity - O(1)