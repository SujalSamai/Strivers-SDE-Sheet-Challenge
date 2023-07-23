package Stacks_Queues.LFUCache;

public class Node {
    int key;
    int val;
    Node next;
    Node prev;
    int freq=1;
    Node(int k,int v){
        key=k;
        val=v;
    }
}
