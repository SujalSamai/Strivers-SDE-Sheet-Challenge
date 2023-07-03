package LinkedList.PalindromeLL;

public class Code {
    static class ListNode{
        int val;
        ListNode next;
        ListNode(){};
        ListNode(int val) {this.val=val;}
        ListNode(int val, ListNode next){
            this.val=val;
            this.next=next;
        }
    }

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
}
