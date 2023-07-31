### Question
- You have been given a binary tree of integers. Your task is to print the boundary nodes of this binary tree in anti-clockwise direction starting from root node.

### Sample Input
    1 2 3 4 -1 5 -1 -1 -1 -1 -1
    1 2 -1 3 -1 4 -1 -1 -1

### Sample Output
    1 2 4 5 3 
    1 2 3 4

### Solution
There are three steps to do the boundary traversal in anti-clockwise direction:
1. Traverse the left boundary of the tree excluding leaf nodes:
    - To traverse the left boundary, we can set a simple iteration. Initially, we make the cur pointer point to the root’s left. In every iteration, if the cur node is not a leaf node, we print it. Then we always try to move left of the cur pointer. If there is no left child, then we move to the right of cur and in the next iteration, again try to move to the left first. We stop our execution when cur is pointing to NULL.
2. Do inorder traversal of all leaf nodes:
   - To print the leaf nodes, we can do a simple preorder traversal, and check if the current node is a leaf node or not. If it is a leaf node just print it.
   Please note that we want the leaves to come in a specific order which is bottom-left to top-right, therefore a level order traversal will not work because it will print the upper-level leaves first. Therefore, we use a preorder traversal.
3. Traverse the right boundary of the tree excluding leaf nodes in reverse direction:
    - It is very similar to the left boundary traversal. We initialize our cur pointer to the right child of the root node and set an iterative loop. To achieve the reverse direction, we take a Stack. In every iteration, we check if the current node is not a leaf node then we push it to the stack. Then we first try to move right of cur, if there is no right child only then we move left. We stop our execution once cur points to NULL. Now the stack contains the nodes of the right boundary. We iterate in the stack and at each pop add the element to our answer list.

### Code
    public static ArrayList<Integer> traverseBoundary(TreeNode root){
        ArrayList<Integer> ans= new ArrayList<>();
        if (!isLeaf(root)) ans.add(root.data);
        leftTraversal(root,ans);
        leafInorder(root,ans);
        rightTraversal(root,ans);
        return ans;
    }

    private static void rightTraversal(TreeNode root, ArrayList<Integer> ans) {
        TreeNode cur= root.right;
        Stack<Integer> st= new Stack<>();
        while (cur!=null){
            if (!isLeaf(cur)) st.push(cur.data);
            if (cur.right==null) cur= cur.left;
            else cur= cur.right;
        }
        while (!st.isEmpty()){
            ans.add(st.pop());
        }
    }

    private static void leafInorder(TreeNode root, ArrayList<Integer> ans) {
        if (isLeaf(root)){
            ans.add(root.data);
            return;
        }
        if (root.left!=null) leafInorder(root.left, ans);
        if (root.right!=null) leafInorder(root.right, ans);
    }

    private static void leftTraversal(TreeNode root, ArrayList<Integer> ans) {
        TreeNode cur= root.left;
        while (cur!=null){
            if (!isLeaf(cur)) ans.add(cur.data);
            if (cur.left==null) cur= cur.right;
            else cur= cur.left;
        }
    }

    private static boolean isLeaf(TreeNode root) {
        return root!=null && root.left==null && root.right==null;
    }

### Edge Cases
- NA

### Other Techniques
- NA

### Complexity
1. Time Complexity - O(N)
2. Space Complexity - O(N)