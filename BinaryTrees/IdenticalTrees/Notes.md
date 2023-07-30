### Question
- Given the roots of two binary trees p and q, write a function to check if they are the same or not. 
- Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.

### Sample Input
    p = [1,2,3], q = [1,2,3]
    p = [1,2], q = [1,null,2]

### Sample Output
    true
    false

### Solution
- In order to check whether two trees are identical or not, we need to traverse the trees. While traversing we first check the value of the nodes, if they are unequal we can simply return false, as trees are non-identical. If they are the same, then we need to recursively check their left child as well as the right child. When we get all the three values as true(node values, left child, right child) we can conclude that these are identical trees and can return true. Any other combination will return false.
- If any of the tree points to null, return if p==q or not

### Code
    public static boolean isSameTree(TreeNode p, TreeNode q){
        if(p==null || q==null) return (p==q);

        return (p.val==q.val) && isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }

### Edge Cases
- NA

### Other Techniques
- NA

### Complexity
1. Time Complexity - O(N)
2. Space Complexity - O(N) - recursion stack