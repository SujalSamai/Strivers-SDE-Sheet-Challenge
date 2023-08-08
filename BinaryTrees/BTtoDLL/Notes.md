### Question
- Given a Binary Tree, convert it to a doubly linked list
- The order of nodes in Doubly Linked List must be same as Inorder of the given Binary tree
- The doubly linked list should be returned by taking the next pointer as right & the previous pointer as left
- You need to return the head of the doubly linked list

### Sample Input
    3 1 5 -1 2 -1 -1 -1 -1
    9 6 10 4 7 -1 11 -1 -1 -1 -1 -1 -1

### Sample Output
    1 2 3 5 
    4 6 7 9 10 11

### Solution
- Take two nodes head & prev pointing to null
- If root = null, return
- We will do inorder traversal, first we call the left sides recursively
- In the root point, we will check, if the prev = null, then this node will be our head
- else we will mark prev.right=root & root.left=prev
- And then change position of prev to root
- At last, call the right side recursively

### Code
    static BinaryTreeNode<Integer> head;
    static BinaryTreeNode<Integer> prev;
    public static BinaryTreeNode<Integer> BTtoDLL(BinaryTreeNode<Integer> root) {
        head=null;
        prev=null;
        helper(root);
        return head;
    }

    private static void helper(BinaryTreeNode<Integer> root) {
        if (root==null) return;
        helper(root.left);
        if (prev==null) head=root;
        else{
            prev.right=root;
            root.left=prev;
        }
        prev=root;
        helper(root.right);
    }

### Other Techniques
- NA

### Complexity
1. Time Complexity - O(N)
2. Space Complexity - O(1)