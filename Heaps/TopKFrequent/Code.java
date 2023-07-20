package Heaps.TopKFrequent;

import java.util.HashMap;
import java.util.PriorityQueue;

public class Code {
    //nlogk
    public static int[] topKFrequent(int[] nums, int k) {
        if(k==nums.length) return nums;
        HashMap<Integer, Integer> map= new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)-> map.get(a) -  map.get(b));
        for (int n: map.keySet()) {
            pq.add(n);
            if (pq.size() > k) pq.poll();
        }

        int[] ans= new int[k];
        for(int i = k - 1; i >= 0; --i) {
            ans[i] = pq.poll();
        }
        return ans;
    }
}
