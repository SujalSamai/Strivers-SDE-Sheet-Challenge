### Question
- Given a Linked List of size N, where every node represents a sub-linked-list and contains two pointers:
  - a next pointer to the next node,
  - a bottom pointer to a linked list where this node is head. 
- Each of the sub-linked-list is in sorted order. 
- Flatten the Link List such that all the nodes appear in a single level while maintaining the sorted order. 
- Note: The flattened list will be printed using the bottom pointer instead of the next pointer.

### Sample Input
    5 -> 10 -> 19 -> 28
    |     |     |     |
    7     20    22   35
    |           |     |
    8          50    40
    |                 |
    30               45

### Sample Output
    5-> 7-> 8- > 10 -> 19-> 20->22-> 28-> 30-> 35-> 40-> 45-> 50.

### Solution
- Using recursion, go to the last second linked list
- merge the current ll with the last ll (taking two lists at a time)
- create a new ll & add elements in sorted array in merge sorted array fashion for both the lists
- now we replaced the two ll with a new merged ll, do the same with all ll

### Code
    public static Node flattenLinkedList(Node head) {
        if (head==null || head.next==null) return head;

        head.next=flattenLinkedList(head.next);     //to start from the last LL
        head= mergeTwoLists(head, head.next);       //before moving to previous LL, merge current & previous LL
        return head;
    }

    private static Node mergeTwoLists(Node a, Node b) {
        Node temp= new Node(0);
        Node res=temp;

        //taking two lists at a time, & merging like merge sorted array fashion
        while (a!=null && b!=null){
            if (a.data<b.data){
                temp.bottom=a;
                temp=temp.bottom;
                a=a.bottom;
            }else{
                temp.bottom=b;
                temp=temp.bottom;
                b=b.bottom;
            }
        }

        //add the remaining elements from the bigger list, since its a ll, hence elements are connected, so we need to do this once only
        if (a!=null) temp.bottom=a;
        else temp.bottom=b;

        //return the head of the new merged list
        return res.bottom;
    }

### Edge Cases
- NA

### Other Techniques
- NA

### Complexity
1. Time Complexity - O(N)
2. Space Complexity - O(1)