package LinkedList.ReverseLL;

public class Code {
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static ListNode reverseList(ListNode head) {
        if (head==null) return head;
        ListNode temp=null;
        while (head!=null){
            ListNode next=head.next;
            head.next=temp;
            temp=head;
            head=next;
        }
        return temp;
    }

    //using recursion
    public ListNode reverseListRecursion(ListNode head){
        if (head==null || head.next==null) return head;
        ListNode temp = reverseListRecursion(head.next);
        head.next.next=head;
        head.next=null;
        return temp;
    }


}
