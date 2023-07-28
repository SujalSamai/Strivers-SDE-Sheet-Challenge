package LinkedList.ReverseNodesSizeK;

public class Code {
    static public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode reverseKGroup(ListNode head, int k){
        if (head== null || head.next== null) return head;
        int length= lengthOfList(head);
        ListNode dummy= new ListNode(0, head);
        ListNode pre= dummy;
        ListNode curr, nex;

        while (length>=k){
            curr= pre.next;
            nex= curr.next;
            for (int i = 1; i < k; i++) {
                curr.next= nex.next;
                nex.next= pre.next;
                pre.next= nex;
                nex= curr.next;
            }

            pre =curr;
            length-=k;
        }
        return dummy.next;
    }

    private int lengthOfList(ListNode head) {
        int len=0;
        while (head!=null){
            ++len;
            head= head.next;
        }
        return len;
    }
}
