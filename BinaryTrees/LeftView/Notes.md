### Question
Given a Binary Tree, return Left view of it. Left view of a Binary Tree is set of nodes visible when tree is visited from Left side. The task is to complete the function leftView(), which accepts root of the tree as argument.

Left view of following tree is 1 2 4 8.

          1
       /     \
     2        3
    /  \    /    \
    4   5   6    7
    \
     8

### Sample Input
          10
        /     \
      20      30
    /   \
    40  60

### Sample Output
    10 20 40

### Solution
- Here, we can see that at each level, we have to print the first node encountered
- getLeftView() function takes the root, our answer list & level
- if level and size of res is same then we add the value of the node to our answer (each level has one node, we are adding the first encountered node)
- we then recursively go to left side first & then right side while increasing the level size (if ans is found in left side, it'll never go to right side)
- if node is pointing to null, we simply return

### Code
    public ArrayList<Integer> leftView(Node root) {
        ArrayList<Integer> res= new ArrayList<>();
        getLeftView(root, res, 0);
        return res;
    }

    private void getLeftView(Node root, ArrayList<Integer> res, int level) {
        if (root==null) return;
        if (level==res.size()) res.add(root.data);

        getLeftView(root.left, res, level+1);
        getLeftView(root.right, res, level+1);
    }

### Edge Cases
- NA

### Other Techniques
- NA

### Complexity
1. Time Complexity - O(N)
2. Space Complexity - O(H)