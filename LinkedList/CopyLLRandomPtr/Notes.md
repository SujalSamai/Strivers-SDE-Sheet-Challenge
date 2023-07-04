### Question
- A linked list of length n is given such that each node contains an additional random pointer, which could point to any node in the list, or null. 
- Construct a deep copy of the list. The deep copy should consist of exactly n brand new nodes, where each new node has its value set to the value of its corresponding original node. Both the next and random pointer of the new nodes should point to new nodes in the copied list such that the pointers in the original list and copied list represent the same list state. None of the pointers in the new list should point to nodes in the original list. 
- Return the head of the copied linked list.

### Sample Input
    [[7,null],[13,0],[11,4],[10,2],[1,0]]
    [[1,1],[2,1]]

### Sample Output
    [[7,null],[13,0],[11,4],[10,2],[1,0]]
    [[1,1],[2,1]]

### Solution
- Iterate through the entire list. 
- For each node, create a deep copy of each node and hash it with it. Store it in the hashmap. 
- Now, again iterate through the given list. For each node, link the deep node present as the hash value of the original node as per original node. 
- the head of the deep copy list will be the head of hashed value of original node.

### Code
    public Node copyRandomList(Node head) {
        Node cur=head;
        HashMap<Node, Node> map=new HashMap<>();
        while (cur!=null){
            map.put(cur, new Node(cur.val));
            cur=cur.next;
        }
        cur=head;
        while (cur!=null){
            map.get(cur).next= map.get(cur.next);
            map.get(cur).random=map.get(cur.random);
            cur=cur.next;
        }
        return map.get(head);
    }

### Edge Cases
- NA

### Other Techniques
- NA

### Complexity
1. Time Complexity - O(max(M,N))
2. Space Complexity - O(max(M,N))