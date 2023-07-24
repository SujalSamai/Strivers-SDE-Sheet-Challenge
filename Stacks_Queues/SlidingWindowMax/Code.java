package Stacks_Queues.SlidingWindowMax;

import java.util.ArrayDeque;
import java.util.Deque;

public class Code {
    public static int[] maxSlidingWindow(int[] nums, int k){
        int n= nums.length;
        Deque<Integer> dq= new ArrayDeque<>();
        int[] ans= new int[n-k+1];
        int x=0;
        for (int i = 0; i < n; i++) {
            if (!dq.isEmpty() && dq.peekFirst() == i-k){
                dq.removeFirst();
            }

            while (!dq.isEmpty() && nums[dq.peekLast()]<nums[i]){
                dq.removeLast();
            }
            dq.add(i);
            if (i >= k-1){
                ans[x++] = nums[dq.peekFirst()];
            }
        }
        return ans;
    }
}
