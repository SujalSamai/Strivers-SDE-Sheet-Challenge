### Question
- Given the head of a singly linked list, return true if it is a palindrome or false otherwise.

### Sample Input
    [1,2,2,1]
    [1,2]

### Sample Output
    true
    false

### Solution
- Using fast & slow ptr, get to the middle of the list
- reverse the later half of the list
- Now point to the head & first element of second part and traverse
- check if both are equal or not

### Code
    public static boolean isPalindrome(ListNode head){
        if(head==null || head.next==null) return true;
        ListNode slow=head;
        ListNode fast=head;

        while (fast.next!=null || fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }

        slow.next=reverse(slow.next);
        slow=slow.next;

        ListNode dummy=head;
        while (slow!=null){
            if(dummy!=slow){
                return false;
            }
            dummy=dummy.next;
            slow=slow.next;
        }
        return true;
    }

    private static ListNode reverse(ListNode ptr) {
        ListNode pre=null;
        ListNode nex=null;
        while (ptr!=null){
            nex=ptr.next;   //marking the next element of list
            ptr.next=pre;   //next of current element is previous element
            pre=ptr;        //previous ptr moved to current one
            ptr=nex;        //current ptr moved to next ptr
        }
        return pre;
    }

### Edge Cases
- Return true if there is only one element in the list

### Other Techniques
- Using extra DS like a table

### Complexity
1. Time Complexity - O(N)
2. Space Complexity - O(1)