package LinkedList.Cycle2;

public class Code {
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {};

        ListNode(int val) {
            this.val = val;
        }
    }

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
}
