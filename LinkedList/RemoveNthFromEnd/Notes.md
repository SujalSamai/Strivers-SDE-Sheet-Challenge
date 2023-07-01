### Question
- Given the head of a linked list, remove the nth node from the end of the list and return its head.

### Sample Input
    [1,2,3,4,5]
    [1]

### Sample Output
    [1,2,3,5]
    []

### Solution
- We know nth node from end is equal to (list length - n) from start
- Traverse the fast pointer to n, keep slow to head
- Now move fast pointer & slow pointer by one place till fast reaches end
- The slow pointer will reach the required node - 1 place
- to delete the nth node from back, just point the slow.next to slow.next.next

### Code
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast=head, slow=head;
        for (int i = 0; i < n; i++) {
            fast=fast.next;
        }
        if (fast==null) return head.next;
        while (fast.next!=null){
            fast=fast.next;
            slow=slow.next;
        }
        slow.next=slow.next.next;
        return head;
    }

### Edge Cases
- if after going to nth place, fast pointer points to null, return head.next because n is actually the length of linked list

### Other Techniques
- Find the length of LL, & again traverse to remove nth node from end

### Complexity
1. Time Complexity - O(N)
2. Space Complexity - O(1)