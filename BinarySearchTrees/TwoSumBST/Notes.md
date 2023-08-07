### Question
- Given the root of a binary search tree and an integer k, return true if there exist two elements in the BST such that their sum is equal to k, or false otherwise.

### Sample Input
    root = [5,3,6,2,4,null,7], k = 9
    root = [5,3,6,2,4,null,7], k = 28

### Sample Output
    true
    false

### Solution
- We know that inorder traversal will give us sorted order of tree
- In BSTIterator question, we use a Stack to find the next element in inorder traversal
- We will use that to do this question in two pointer approach
- We will initiate left pointer to the leftmost node which is the smallest one, & right pointer to rightmost node which is the largest one
- At each step we will check if both nodes add upto make k, if k is less then we will move the right pointer to left, if k is more we will move left pointer to right
- BSTIterator, creates an iterator for both left & right, the constructor pushes all the left elements of BT in stack in case of left pointer & in case of right pointer, all the right elements of BT are pushed in stack. The variable reverse keeps track of which pointer we are using currently
- next() pointer, pops out from stack & pushes the right side of the node for left pointer & vice versa for right pointer & returns node's value

### Code
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

        int i = left.next();
        int j = right.next();

        while (i<j){
            if (i+j==k) return true;
            if (i+j < k) i = left.next();
            else j= right.next();
        }
        return false;
    }

### Other Techniques
- We can simply do inorder traversal & store it in an array & then do two pointer approach in the inorder arr

### Complexity
1. Time Complexity - O(N)
2. Space Complexity - O(2H)