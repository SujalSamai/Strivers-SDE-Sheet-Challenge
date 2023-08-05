### Question
- Given a binary search tree (BST), find the lowest common ancestor (LCA) node of two given nodes in the BST. 
- According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”

### Sample Input
    root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
    root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4

### Sample Output
    6
    2

### Solution
- We will simply traverse the tree, we know two nodes can be either smaller (left side) or greater (right side) to our current node
- But if one of them is small(left) & one of them is greater(right), then we can say that current node is their ancestor
- So, we will traverse the tree if root.val is smaller than both p & q, move to left
- if root.val is greater than both p & q, move to right
- in all other cases return the root, it is our LCA

### Code
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        while (root!=null){
            if (root.val > p.val && root.val > q.val){
                root = root.left;
            }else if (root.val < p.val && root.val < q.val){
                root = root.right;
            }else{
                return root;
            }
        }
        return root;
    }

### Other Techniques
- Recursion

### Complexity
1. Time Complexity - O(N)
2. Space Complexity - O(1)