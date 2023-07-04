package LinkedList.CopyLLRandomPtr;

import java.util.HashMap;

public class Code {
    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public static Node copyRandomList(Node head){
        Node newLL= head;
        HashMap<Node, Node> map=new HashMap<>();
        while (newLL!=null){
            map.put(newLL, new Node(newLL.val));    //adds our node from original list & another node which has same value as original node
            newLL=newLL.next;
        }

        newLL=head;
        while (newLL!=null){
            map.get(newLL).next= map.get(newLL.next);
            map.get(newLL).random= map.get(newLL.random);
            newLL= newLL.next;
        }
        return map.get(head);
    }
}
