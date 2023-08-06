### Question
- You are given a perfect binary tree where all leaves are on the same level, and every parent has two children. The binary tree has the following definition:

    `struct Node {
    int val;
    Node *left;
    Node *right;
    Node *next;
    }`

- Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

### Sample Input
    root = [1,2,3,4,5,6,7]
    root = []

### Sample Output
    [1,#,2,3,#,4,5,6,7,#]
    []

### Solution
- We will do level order traversal, initially we will add the root in the queue
- traverse till queue is not empty, then traverse in each level
- Pop out from queue, if the current node is not the last node in the level, then node.next=queue.peek
- add the node's left & right nodes to the queue & repeat the process

### Code
    public Node connect(Node root) {
        if (root == null) return null;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                Node node = queue.poll();
                if(i < size - 1) {
                    node.next = queue.peek();
                }
                if(node.left != null) {
                    queue.offer(node.left);
                }
                if(node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return root;
    }

### Other Techniques
- DFS

### Complexity
1. Time Complexity - O(N)
2. Space Complexity - O(N)