### Question
- You have been given a binary search tree of integers with 'N' nodes. You are also given 'KEY' which represents data of a node of this tree. Your task is to find the predecessor and successor of the given node in the BST.

### Sample Input
    15 10 20 8 12 16 25 -1 -1 -1 -1 -1 -1 -1 -1, key=10
    10 5 -1 -1 -1, key=5

### Sample Output
    8 12
    -1 10

### Solution
- We know inorder traversal gives the numbers in sorted order
- In predecessor, predecessor's value will be less than key, if key <= node.val, then we move to left side as we need less value, else we store root.val in variable & check on right side to get more close answer
- In successor, successor's value will be greater than key, if key >= node.val, then we move to right side as we need greater value, else we store root.val in variable & check on left side to get more close answer

### Code
    public static ArrayList<Integer> predecessorSuccessor(TreeNode<Integer> root, int key) {
        ArrayList<Integer> ans= new ArrayList<>();
        ans.add(predecessor(root, key));
        ans.add(successor(root,key));
        return ans;
    }

    private static int predecessor(TreeNode<Integer> root, int key) {
        int pre = -1;
        while (root!=null){
            if (key <= root.data){
                root = root.left;
            }else{
                pre = root.data;
                root= root.right;
            }
        }
        return pre;
    }

    private static int successor(TreeNode<Integer> root, int key) {
        int suc = -1;
        while (root!=null){
            if (key >= root.data){
                root= root.right;
            }else{
                suc= root.data;
                root = root.left;
            }
        }
        return suc;
    }

### Other Techniques
- NA

### Complexity
1. Time Complexity - O(H)
2. Space Complexity - O(1)