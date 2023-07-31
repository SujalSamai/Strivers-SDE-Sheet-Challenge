### Question
- Given the root of a binary tree, return the zigzag level order traversal of its nodes' values. (i.e., from left to right, then right to left for the next level and alternate between)

### Sample Input
    root = [3,9,20,null,null,15,7]
    root = [1]

### Sample Output
    [[3],[20,9],[15,7]]
    [[1]]

### Solution
- We will do level order traversal as it is
- Create a queue ds, add root to it & traverse the queue till it's not empty
- Get the size of queue at each traversal & traverse inside it. Pop an element from queue, add its value to subList, then if left/right is present to current node, recursively go there
- This way we will have our level order traversal, now to do zigzag traversal, initialise a variable level, and whenever our level is even, reverse the sublist

### Code
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root){
        Queue<TreeNode> queue= new LinkedList<>();
        List<List<Integer>> list= new ArrayList<>();
        if (root==null) return list;

        queue.add(root);
        int level=1;
        while (!queue.isEmpty()){
            int size= queue.size();
            List<Integer> sublist= new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                sublist.add(node.val);
                if (node.left!=null){
                    queue.add(node.left);
                }
                if (node.right!=null){
                    queue.add(node.right);
                }
            }
            if (level%2==0) Collections.reverse(sublist);
            list.add(sublist);
            level++;
        }
        return list;
    }

### Edge Cases
- NA

### Other Techniques
- NA

### Complexity
1. Time Complexity - O(N)
2. Space Complexity - O(N)