### Question
- Given a Binary search tree. Your task is to complete the function which will return the Kth largest element without doing any modification in Binary Search Tree.

### Sample Input
    root = [4,2,9], k = 2
    root = [9, null, 10], k = 1

### Sample Output
    4
    10

### Solution
- Inorder traversal of a BST gives all the nodes in sorted order, with this property we can do this question easily
- We will take a res arr, res[0] will store count, & res[1] will store result (we are taking an array because in java pass by reference is possible via array)
- Now we will do inorder traversal, as we want the reverse of kthSmallest so we will do recursion to right side first, whenever we reach a Root Node, we will increase counter & check if our counter == k, if yes then our res will be root.val & we will return, & left side recursion at last

### Code
    public int kthLargest(Node root, int K){
        int[] res= {0, -1};     // res[0]= count, res[1]=result
        inorder(root, K, res);
        return res[1];
    }

    private void inorder(Node root, int k, int[] res) {
        if (root==null) return;

        inorder(root.right, k, res);
        res[0]= res[0]+1;   //count++

        if (res[0]==k){     //count==k, return result
            res[1]=root.data;
            return;
        }

        inorder(root.left, k, res);
    }

### Other Techniques
- NA

### Complexity
1. Time Complexity - O(N)
2. Space Complexity - O(N) stack space