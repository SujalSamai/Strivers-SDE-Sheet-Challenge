### Question
- Given the head of a linked list, return the node where the cycle begins. If there is no cycle, return null. 
- There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to (0-indexed). It is -1 if there is no cycle. Note that pos is not passed as a parameter. 
- Do not modify the linked list.

### Sample Input
    [3,2,0,-4]
    [1,2]

### Sample Output
    2
    0

### Solution
- Using fast & slow ptr, get to the point where the ptrs meet
- if cycle exist, they'll definitely meet
- now move slow to head, and again move both fast & slow one by one
- the point where they meet, is cycle entry

### Code
    public static ListNode detectCycle(ListNode head){
        ListNode slow=head, fast=head;

        while (fast!=null || fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if (fast==slow) break;
        }

        if (fast==null || fast.next==null) return null;

        slow=head;
        while (slow!=fast){
            slow=slow.next;
            fast=fast.next;
        }
        return fast;
    }

### Edge Cases
- If fast points to null, cycle is not present return null

### Other Techniques
- Hashset

### Complexity
1. Time Complexity - O(N)
2. Space Complexity - O(1)