### Question
- Given an integer array nums where the elements are sorted in ascending order, convert it to a height-balanced binary search tree.

### Sample Input
    nums = [-10,-3,0,5,9]
    nums = [1,3]

### Sample Output
    [0,-3,9,-10,null,5]
    [3,1]

### Solution
- We are given a sorted array, then we can say that we have been given inorder traversal of the BST
- So we will just use Binary search on the given sorted array
- We will find the middle element, create a node, left of it will be already small, & right will be already greater
- we will recursively create the left & right nodes based on binary search

### Code
    public static TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length==0) return null;
        return createBST(nums, 0, nums.length-1);
    }

    private static TreeNode createBST(int[] nums, int l, int r) {
        if (l>r) return null;

        int mid = l + (r - l) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = createBST(nums, l, mid-1);
        root.right = createBST(nums, mid+1, r);
        return root;
    }

### Other Techniques
- NA

### Complexity
1. Time Complexity - O(logN)
2. Space Complexity - O(N)