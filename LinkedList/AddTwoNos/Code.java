package LinkedList.AddTwoNos;

public class Code {
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    //Each node contains a single digit and the digits are stored in reverse order
    //carry must be either 0 or 1 because the largest possible sum of two digits (including the carry) is 9 + 9 + 1 = 19
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2){
        ListNode dummy= new ListNode();
        ListNode temp= dummy;
        int carry=0;

        while (l1!=null || l2!=null || carry==1){
            int sum=0;
            if (l1!=null){
                sum+=l1.val;
                l1=l1.next;
            }
            if (l2!=null){
                sum+=l2.val;
                l2=l2.next;
            }

            sum+=carry;
            carry=sum/10;
            ListNode node= new ListNode(sum%10);
            temp.next=node;
            temp=temp.next;
        }
        return dummy.next;
    }
}
