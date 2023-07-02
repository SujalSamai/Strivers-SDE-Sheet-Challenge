### Question
- There is a singly-linked list head and we want to delete a node node in it.
- You are given the node to be deleted node. You will not be given access to the first node of head.
- All the values of the linked list are unique, and it is guaranteed that the given node node is not the last node in the linked list.
- Delete the given node. Note that by deleting the node, we do not mean removing it from memory. We mean:
    - The value of the given node should not exist in the linked list.
    - The number of nodes in the linked list should decrease by one.
    - All the values before node should be in the same order.
    - All the values after node should be in the same order.

### Sample Input
    head = [4,5,1,9], node = 5
    head = [4,5,1,9], node = 1

### Sample Output
    [4,1,9]
    [4,5,9]

### Solution
- Take two dummy nodes for each list. Point each to the head of the lists. 
- Iterate over them. If anyone becomes null, point them to the head of the opposite lists and continue iterating until they collide.

### Code
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode d1=headA;
        ListNode d2=headB;

        while (d1!=d2){
            d1= d1==null ? headB : d1.next;
            d2= d2==null ? headA : d2.next;
        }
        return d1;
    }

### Edge Cases
- NA

### Other Techniques
- Nested Loops, searching
- Hashing
- Find the length of shorter LL, traverse the bigger LL for difference of length, then traverse both the list till we get intersection

### Complexity
1. Time Complexity - O(2*max(M,N))
2. Space Complexity - O(1)