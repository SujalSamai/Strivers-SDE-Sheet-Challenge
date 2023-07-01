### Question
- Given the head of a singly linked list, return the middle node of the linked list. 
- If there are two middle nodes, return the second middle node.

### Sample Input
    [1,2,3,4,5]
    [1,2,3,4,5,6]

### Sample Output
    [3,4,5]
    [4,5,6]

### Solution
- In the Tortoise-Hare approach, we increment slow ptr by 1 and fast ptr by 2.
- So if we take a close look fast ptr will travel double that of the slow pointer. 
- So when the fast ptr will be at the end of the Linked List, slow ptr would have covered half of the Linked List till then. 
- Hence, slow ptr will be pointing towards the middle of Linked List.

### Code
    public static ListNode middleNode(ListNode head){
        ListNode slow=head, fast=head;
        while (fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }

### Edge Cases
- if there's no item present return head, which is null

### Other Techniques
- We can traverse the whole LL & count its length, then traverse again till n/2 nodes

### Complexity
1. Time Complexity - O(N)
2. Space Complexity - O(1)