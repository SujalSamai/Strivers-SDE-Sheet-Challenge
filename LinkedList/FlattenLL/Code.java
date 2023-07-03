package LinkedList.FlattenLL;

public class Code {
    static class Node
    {
        int data;
        Node next;
        Node bottom;

        Node(int d)
        {
            data = d;
            next = null;
            bottom = null;
        }
    }

    public static Node flattenLinkedList(Node head) {
        if (head==null || head.next==null) return head;

        head.next=flattenLinkedList(head.next);     //to start from the last LL
        head= mergeTwoLists(head, head.next);       //before moving to previous LL, merge current & previous LL
        return head;
    }

    private static Node mergeTwoLists(Node a, Node b) {
        Node temp= new Node(0);
        Node res=temp;

        //taking two lists at a time, & merging like merge sorted array fashion
        while (a!=null && b!=null){
            if (a.data<b.data){
                temp.bottom=a;
                temp=temp.bottom;
                a=a.bottom;
            }else{
                temp.bottom=b;
                temp=temp.bottom;
                b=b.bottom;
            }
        }

        //add the remaining elements from the bigger list, since its a ll, hence elements are connected, so we need to do this once only
        if (a!=null) temp.bottom=a;
        else temp.bottom=b;

        //return the head of the new merged list
        return res.bottom;
    }
}
