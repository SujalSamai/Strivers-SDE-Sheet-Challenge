### Question
- You are given the root node of a binary search tree (BST) and a value to insert into the tree. Return the root node of the BST after the insertion. It is guaranteed that the new value does not exist in the original BST. 
- Notice that there may exist multiple valid ways for the insertion, as long as the tree remains a BST after insertion. You can return any of them.

### Sample Input
    root = [4,2,7,1,3], val = 5
    root = [40,20,60,10,30,50,70], val = 25

### Sample Output
    [4,2,7,1,3,5]
    [40,20,60,10,30,50,70,null,null,25]

### Solution
- If our root is null, we will simply create a new node with the value & return it
- Else we will take a dummy node = root & traverse in the given tree
- if our dummy.val <= val, so we should move to right side, if dummy.right is not null, we can move right, but if it is null, we simply create the new node & attach it to our dummy.right
- else our dummy.val > val, so we should move to left side, if dummy.left is not null, we can move left, but if it is null, we simply create the new node & attach it to our dummy.left

### Code
    public static TreeNode insertIntoBST(TreeNode root, int val){
        if (root==null) return new TreeNode(val);
        TreeNode cur= root;
        while (true){
            if (cur.val<=val){
                if (cur.right!= null) cur= cur.right;
                else{
                    cur.right= new TreeNode(val);
                    break;
                }
            }else{
                if (cur.left!=null) cur=cur.left;
                else{
                    cur.left= new TreeNode(val);
                    break;
                }
            }
        }
        return root;
    }

### Other Techniques
- NA

### Complexity
1. Time Complexity - O(N)
2. Space Complexity - O(1)