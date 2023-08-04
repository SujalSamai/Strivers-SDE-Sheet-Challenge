### Question
- Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.

### Sample Input
    preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
    preorder = [-1], inorder = [-1]

### Sample Output
    [3,9,20,null,null,15,7]
    [-1]

### Solution
- Inorder traversal is a special traversal that helps us to identify a node and its left and right subtree. Preorder traversal always gives us the root node as the first element
![img.png](img.png)
- Here 10 (first element of preorder) is the root element. So we can find its index in the inorder traversal(say elem). The left subtree of the root will be present to the left side of in order whereas the right subtree of root will be present on the right side of elem in the inorder traversal
- We can define a recursive function that creates one node at a time. First, we create the root node, and then we can take the help of recursion to create its left and right subtrees. In order to make recursion work, we need to provide the correct inorder and preorder traversal of the subtree for every recursive call.
- To make more efficient function calls we can use variables (inStart, inEnd) and (preStart and preEnd) in order to point to the start and end of the inorder and preorder traversal respectively, and avoid copying of arrays. 
- Next, we need to figure out how we are going to search the root index in the inorder traversal. For this, we have two options: Linear Search and Hashmaps. We will choose the second one because it will return us the index in constant time. Before making the first recursive call, we will simply add all the (value, index) pairs to a map and pass it to our recursive function.
- Now the main task left is to pass the correct preStart, preEnd, inStart, inEnd to the respective recursive calls for the left and right subtree. We can calculate the number of elements in the left subtree from the root index, say nElems (elem – InStart, where elem is the index of root in inorder traversal). As inorder is [left, root, right] and preorder is [root, left, right] the number of elements (nElems) will easily tell us the preorder and inorder traversal of the subtrees according to the following table:
![img_1.png](img_1.png)
- The base case will be when inStart> inEnd or preStart > preEnd, in that case, we can simply return NULL.

### Code
     public static TreeNode buildTree(int[] preorder, int[] inorder){
        HashMap<Integer, Integer> map= new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i],i);
        }

        return buildTreeRoot(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1, map);
    }

    private static TreeNode buildTreeRoot(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, HashMap<Integer, Integer> map) {
        if (preStart>preEnd || inStart>inEnd) return null;
        TreeNode root= new TreeNode(preorder[preStart]);
        int inRoot= map.get(root.val);
        int numsLeft= inRoot - inStart;

        root.left= buildTreeRoot(preorder, preStart+1, preStart+numsLeft, inorder, inStart, inRoot-1, map);
        root.right= buildTreeRoot(preorder, preStart+numsLeft+1, preEnd, inorder, inRoot+1, inEnd, map);

        return root;
    }

### Edge Cases
- NA

### Other Techniques
- NA

### Complexity
1. Time Complexity - O(N)
2. Space Complexity - O(N)