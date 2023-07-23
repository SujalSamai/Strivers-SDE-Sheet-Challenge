package Stacks_Queues.LFUCache;

public class DoublyLinkedList{
    Node head;
    Node tail;
    DoublyLinkedList(){
        head=new Node(-1,-1);
        tail=new Node(-1,-1);
        head.next=tail;
        tail.prev=head;
    }
    void addNode(Node v){
        Node next=head.next;
        head.next=v;
        v.prev=head;
        head.next=v;
        v.next=next;
        next.prev=v;
    }
    Node removeNode(){
        Node node=tail.prev;
        node.prev.next=tail;
        tail.prev=node.prev;
        return node;
    }
    Node removeNode(Node v){
        Node prev=v.prev;
        Node next=v.next;
        prev.next=next;
        next.prev=prev;
        return v;
    }
    boolean isEmpty(){
        if(head.next==tail)
            return true;
        return false;
    }
}
