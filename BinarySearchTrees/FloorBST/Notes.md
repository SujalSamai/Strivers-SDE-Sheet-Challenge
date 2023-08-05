### Question
- You are given a Binary Search tree and an integer Key
- You have to find the floor value of the key in the given binary search tree
- Floor of an integer is the closest integer, lesser than or equal to a given number

### Sample Input
    root = [10, 5, 15, 2, 6, -1, -1, -1, -1, -1, -1], val = 7
    root = [2, 1, 3, -1, -1, -1, -1], val = 2

### Sample Output
    6
    2

### Solution
- Take a variable floor=-1
- Traverse in the tree till node!=null
- if key < node.val, then we must go to left side as there can be a lesser value closer to key
- else if key > node.val, then we mark floor= node.val as this can be a potential answer and go to right side, as there is a chance to get much closer value
- if node.val==key, floor=node.val and return floor
- else automatically return the closest value

### Code
    public static int floorInBST(TreeNode<Integer> root, int X) {
        int floor = -1;
        while (root!=null){
            if (root.data==X){
                floor= root.data;
                return floor;
            }
            if (X > root.data){
                floor= root.data;
                root= root.right;
            }else{
                root= root.left;
            }
        }
        return floor;
    }

### Other Techniques
- NA

### Complexity
1. Time Complexity - O(log N)
2. Space Complexity - O(1)