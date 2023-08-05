### Question
- Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) of all the values of the nodes in the tree.

### Sample Input
    root = [3,1,4,null,2], k = 1
    root = [5,3,6,2,4,null,null,1], k = 3

### Sample Output
    1
    3

### Solution
- Inorder traversal of a BST gives all the nodes in sorted order, with this property we can do this question easily
- We will take a res arr, res[0] will store count, & res[1] will store result (we are taking an array because in java pass by reference is possible via array)
- Now we will do inorder traversal, whenever we reach a Root Node, we will increase counter & check if our counter == k, if yes then our res will be root.val & we will return

### Code
    public int kthSmallest(TreeNode root, int k){
        int[] res= {0, -1};     // res[0]= count, res[1]=result
        inorder(root, k, res);
        return res[1];
    }

    private void inorder(TreeNode root, int k, int[] res) {
        if (root==null) return;

        inorder(root.left, k, res);
        res[0]= res[0]+1;   //count++

        if (res[0]==k){     //count==k, return result
            res[1]=root.val;
            return;
        }

        inorder(root.right, k, res);
    }

### Other Techniques
- NA

### Complexity
1. Time Complexity - O(N)
2. Space Complexity - O(N) stack space