### Question
- Given the root of a binary tree, return all root-to-leaf paths in any order.

### Sample Input
    root = [1,2,3,null,5]
    root = [1]

### Sample Output
    ["1->2->5","1->3"]
    ["1"]

### Solution
- We need to return a List of Strings with each string being path to a leaf node
- If our root is null, return back. Else get the length of our string first and add the value of current node after that
- Now check, if left & right of current Node is null, then add the current String to our answer list
- Else, we haven't reached leaf node yet, so append "->" and go to left & right one by one recursively
- Once the recursion is done, make sure to remove the last node from the string while backtracking, so that we can go to a different path

### Code
     public static List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        helper(res, root, sb);
        return res;
    }

    private static void helper(List<String> res, TreeNode root, StringBuilder sb) {
        if(root == null) return;
        int len = sb.length();
        sb.append(root.val);
        if(root.left == null && root.right == null) {
            res.add(sb.toString());
        } else {
            sb.append("->");
            helper(res, root.left, sb);
            helper(res, root.right, sb);
        }
        sb.setLength(len);
    }

### Edge Cases
- NA

### Other Techniques
- NA

### Complexity
1. Time Complexity - O(N)
2. Space Complexity - O(N)