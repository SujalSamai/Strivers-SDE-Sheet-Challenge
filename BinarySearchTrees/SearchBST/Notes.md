### Question
- You are given the root of a binary search tree (BST) and an integer val. 
- Find the node in the BST that the node's value equals val and return the subtree rooted with that node. If such a node does not exist, return null.

### Sample Input
    root = [4,2,7,1,3], val = 2
    root = [4,2,7,1,3], val = 5

### Sample Output
    [2,1,3]
    []

### Solution
- As it is a BST, we know left of node will always be less and right of node will always be greater
- So we will traverse till root is null or root's value is same as the key
- if key < root.val, we go left, else we go right
- If root.val==key, return root or if root==null return null (we couldn't find key)

### Code
    public static TreeNode searchBST(TreeNode root, int val){
        while (root!= null && root.val!=val){
            if (val < root.val){
                root= root.left;
            }else{
                root = root.right;
            }
        }
        return root;
    }

### Other Techniques
- NA

### Complexity
1. Time Complexity - O(log N)
2. Space Complexity - O(1)