package Heaps.KthLargestInStream;

import java.util.PriorityQueue;

public class KthLargest {
    PriorityQueue<Integer> pq= new PriorityQueue<>();
    int k;
    public KthLargest(int k, int[] nums) {
        this.k= k;
        for (int num:nums) {
            pq.add(num);
        }
    }

    public int add(int val) {
        pq.add(val);
        while (pq.size()>k){
            pq.poll();
        }
        return pq.peek();
    }
}
