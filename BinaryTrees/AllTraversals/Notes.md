### Question
- You have been given a Binary tree of 'N' nodes, where the nodes have integer values. Your task is to find the In-Order, Pre-Order & Post-Order traversals of the binary tree

### Sample Input
    1 2 3 -1 -1 -1  6 -1 -1
    1 2 3 -1 -1 -1 -1

### Sample Output
    [[2 1 3 6],[1 2 3 6], [2 6 3 1]]
    [[2 1 3], [1 2 3], [2 3 1]]

### Solution
- We will use a Stack of Pair(Node, num) where Node is the node from the graph & num is the indicator of in which list we should keep the node
- We initially push, root and 1 to stack
- Now till stack is empty, traverse. First Pop from the stack and store the pair in a variable, let it call 'it'
- if the it.num==1 then we will add the value of the current node to preorder list, then we will increment it.num & push 'it' back to stack. If there is a left node attached to the current node, then push the left node with value as 1 to stack
- if it.num==2 then we will add the value of the current node to the inorder list, then we will increment it.num & push 'it' back to stack.If there is a right node attached to the current node, then push right node with value as 1 to stack
- else just add value of current node to postorder list
- At last add all the three lists to our answer list

### Code
    static class Pair{
        BinaryTreeNode<Integer> node;
        int num;
        Pair(BinaryTreeNode<Integer> node, int num){
            this.node=node;
            this.num=num;
        }
    }

    public static List<List<Integer>> getTreeTraversal(BinaryTreeNode<Integer> root) {
        List<List<Integer>> res= new ArrayList<>();
        List<Integer> pre= new ArrayList<>();
        List<Integer> in= new ArrayList<>();
        List<Integer> post= new ArrayList<>();
        if (root==null) return res;
        Stack<Pair> st= new Stack<>();
        st.push(new Pair(root, 1));

        while (!st.isEmpty()){
            Pair it= st.pop();
            if (it.num==1){
                pre.add(it.node.data);
                it.num++;
                st.push(it);
                if(it.node.left!=null){
                    st.push(new Pair(it.node.left, 1));
                }
            }
            else if (it.num==2){
                in.add(it.node.data);
                it.num++;
                st.push(it);
                if (it.node.right!=null){
                    st.push(new Pair(it.node.right, 1));
                }
            }
            else {
                post.add(it.node.data);
            }
        }
        res.add(in);
        res.add(pre);
        res.add(post);
        return res;
    }

### Edge Cases
- NA

### Other Techniques
- NA

### Complexity
1. Time Complexity - O(N)
2. Space Complexity - O(N)