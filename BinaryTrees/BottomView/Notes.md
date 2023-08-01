### Question
- Given a binary tree, print the bottom view from left to right. 
- A node is included in bottom view if it can be seen when we look at the tree from bottom.
- If there are multiple bottom-most nodes for a horizontal distance from root, then print the later one in level traversal.

### Sample Input
    root = [1,3,2]
    root = [10,20,30,40,60,null,null]

### Sample Output
    [3, 1, 2]
    [40, 20, 60, 30]

### Solution
- We will use the concept of Position indexes again, we will do level order traversing
- We will take a queue of Nodes & a TreeMap to store the node's value sorted in order of their positions in x-axis (hd)
- Initially store the root in queue and make its hd=0, then traverse till queue is empty
- pop from queue & store it's hd & value in the map
- Check recursively in left & right direction for nodes
- At the end we will have all node's value sorted in order of their positions in x-axis in the map
- We will traverse in the map & add all the values in our answer list & return it

### Code
    public static ArrayList<Integer> bottomView(Node root) {
        ArrayList<Integer> ans= new ArrayList<>();
        TreeMap<Integer, Integer> map= new TreeMap<>();
        Queue<Node> q = new LinkedList<>();
        if (root==null) return ans;
        root.hd=0;
        q.add(root);
        while (!q.isEmpty()){
            Node temp= q.poll();
            int hd= temp.hd;
            map.put(hd, temp.data);
            if (temp.left!=null){
                temp.left.hd= hd-1;
                q.add(temp.left);
            }
            if (temp.right!=null){
                temp.right.hd=hd+1;
                q.add(temp.right);
            }
        }

        for (Map.Entry<Integer, Integer> entry: map.entrySet()){
            ans.add(entry.getValue());
        }
        return ans;
    }

### Edge Cases
- NA

### Other Techniques
- NA

### Complexity
1. Time Complexity - O(N)
2. Space Complexity - O(N)