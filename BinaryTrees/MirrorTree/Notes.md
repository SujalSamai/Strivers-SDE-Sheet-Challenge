### Question
- Given a Binary Tree, convert it into its mirror.
    ```
     1    (mirror)   1
    /  \    =>      /  \
   2    3          3    2
  ``` 

### Sample Input
        10
       /  \
      20   30
     /  \
    40  60

### Sample Output
    30 10 60 20 40

### Solution
- Recursively go to the left & right children
- Swap left & right children

### Code
    static void mirror(Node node) {
        if (node==null) return;
        mirror(node.left);
        mirror(node.right);
        Node temp= node.left;
        node.left= node.right;
        node.right= temp;
    }

### Edge Cases
- NA

### Other Techniques
- NA

### Complexity
1. Time Complexity - O(N)
2. Space Complexity - O(H)