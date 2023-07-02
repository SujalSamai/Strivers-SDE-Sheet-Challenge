package LinkedList.Intersection;

public class Code {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next=null;
        }
    }
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB){
        ListNode ptr1=headA;
        ListNode ptr2=headB;

        while (ptr1!=ptr2){
            ptr1 = ptr1==null ? headB : ptr1.next;
            ptr2= ptr2==null ? headA : ptr2.next;
        }
        return ptr1;
    }
}
