### Question
- Given head, the head of a linked list, determine if the linked list has a cycle in it.
- There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter. 
- Return true if there is a cycle in the linked list. Otherwise, return false.

### Sample Input
    head = [3,2,0,-4], pos = 1
    head = [1,2], pos = 0
    head = [1], pos = -1

### Sample Output
    true
    true
    false

### Solution
- We will take two pointers, namely fast and slow. Fast pointer takes 2 steps ahead and slow pointer takes 2 points ahead. 
- Iterate through the list until the fast pointer is equal to NULL. This is because NULL indicates that there is no cycle present in the given list. 
- Cycle can be detected when fast and slow pointers collide.

### Code
    public static boolean hasCycle(ListNode head){
        ListNode fast=head;
        ListNode slow=head;

        while (fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if (fast==slow){
                return true;
            }
        }
        return false;
    }

### Edge Cases
- NA

### Other Techniques
- Hashing

### Complexity
1. Time Complexity - O(N)
2. Space Complexity - O(1)