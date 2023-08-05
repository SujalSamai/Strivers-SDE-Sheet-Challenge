### Question
- You are given a Binary Search tree and an integer Key
- You have to find the ceil value of the key in the given binary search tree
- Ceil of an integer is the closest integer, greater than or equal to a given number

### Sample Input
    root = [8, 5, 10, 2, 6, -1, -1, -1, -1, -1, 7, -1, -1], val = 4
    root = [8, 5, 10, 2, 6, -1, -1, -1, -1, -1, 7, -1, -1], val = 7

### Sample Output
    5
    7

### Solution
- Take a variable ceil=-1
- Traverse in the tree till node!=null
- if key > node.val, then we must go to right side as there can be a greater value closer to key
- else if key < node.val, then we mark ceil= node.val as this can be a potential answer and go to left side, as there is a chance to get much closer value
- if node.val==key, ceil=node.val and return ceil
- else automatically return the closest value

### Code
    public  static int findCeil(TreeNode<Integer> node, int x) {
        int ceil = -1;
        while (node != null){
            if (node.data==x){
                ceil= node.data;
                return ceil;
            }
            if (x > node.data){
                node = node.right;
            }else{
                ceil= node.data;
                node= node.left;
            }
        }
        return ceil;
    }

### Other Techniques
- NA

### Complexity
1. Time Complexity - O(log N)
2. Space Complexity - O(1)