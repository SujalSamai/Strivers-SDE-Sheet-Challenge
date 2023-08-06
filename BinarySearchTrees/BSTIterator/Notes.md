### Question
- Implement the BSTIterator class that represents an iterator over the in-order traversal of a binary search tree (BST):
  - BSTIterator(TreeNode root) Initializes an object of the BSTIterator class. The root of the BST is given as part of the constructor. The pointer should be initialized to a non-existent number smaller than any element in the BST. 
  - boolean hasNext() Returns true if there exists a number in the traversal to the right of the pointer, otherwise returns false. 
  - int next() Moves the pointer to the right, then returns the number at the pointer. 
- Notice that by initializing the pointer to a non-existent smallest number, the first call to next() will return the smallest element in the BST. 
- You may assume that next() calls will always be valid. That is, there will be at least a next number in the in-order traversal when next() is called.

### Sample Input
    ["BSTIterator", "next", "next", "hasNext", "next", "hasNext", "next", "hasNext", "next", "hasNext"]
    [[[7, 3, 15, null, null, 9, 20]], [], [], [], [], [], [], [], [], []]

### Sample Output
    [null, 3, 7, true, 9, true, 15, true, 20, false]

### Solution
- We will use a Stack to implement this
- In the constructor, we will push all the left child of the root in the stack
- When next() is called, we will pop out from stack, push all the right nodes of the popped node (if present) in the stack & return the popped node's value
- hasNext() will return true if stack is not empty

### Code
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

### Other Techniques
- NA

### Complexity
1. Time Complexity - O(1)
2. Space Complexity - O(H)