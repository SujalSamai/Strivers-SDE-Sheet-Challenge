package Stacks_Queues.LFUCache;

import java.util.HashMap;

public class LFUCache {
    HashMap<Integer,DoublyLinkedList> freqList=new HashMap<Integer,DoublyLinkedList>();
    HashMap<Integer,Node> lfuCache =new HashMap<Integer,Node>();
    int capacity;
    int minFreq;
    public LFUCache(int capacity) {
        this.capacity=capacity;
        minFreq=1;
    }
    public int get(int key) {
        if(lfuCache.get(key)==null)
            return -1;
        Node v=lfuCache.get(key);
        freqList.get(v.freq).removeNode(v);
        if(freqList.get(v.freq).isEmpty()){
            if(minFreq==v.freq){
                minFreq=v.freq+1;
            }
        }
        v.freq+=1;
        if(freqList.get(v.freq)==null){
            DoublyLinkedList d=new DoublyLinkedList();
            d.addNode(v);
            freqList.put(v.freq,d);
        }
        else{
            freqList.get(v.freq).addNode(v);
        }
        return v.val;
    }

    public void put(int key, int value) {
        if (capacity == 0)
            return;
        if (lfuCache.get(key) != null) {
            Node v = lfuCache.get(key);
            freqList.get(v.freq).removeNode(v);
            if (freqList.get(v.freq).isEmpty()) {
                if (minFreq == v.freq)
                    minFreq = v.freq + 1;
            }
            v.freq += 1;
            if (freqList.get(v.freq) == null) {
                DoublyLinkedList d = new DoublyLinkedList();
                d.addNode(v);
                freqList.put(v.freq, d);
            } else {
                freqList.get(v.freq).addNode(v);
            }
            v.val = value;
        } else {
            if (lfuCache.size() == capacity) {
                Node v = freqList.get(minFreq).removeNode();
                lfuCache.remove(v.key);
            }
            Node newNode = new Node(key, value);
            lfuCache.put(key, newNode);
            if (freqList.get(1) != null) {
                freqList.get(1).addNode(newNode);
            } else {
                DoublyLinkedList d = new DoublyLinkedList();
                d.addNode(newNode);
                freqList.put(1, d);
            }
            minFreq = 1;
        }
    }
}
