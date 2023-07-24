### Question
- You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position. 
- Return the max sliding window.

### Sample Input
    nums = [1,3,-1,-3,5,3,6,7], k = 3
    nums = [1], k = 1

### Sample Output
    [3,3,5,5,6,7]
    [1]

### Intuition
Window : [1,2,3]  and the next incoming value is 2

- For this state, we get a maximum of 3. However, when our state changes to, [2,3,2] we again check what is the largest element even though we know that the outgoing element is not the largest one. Hence, the point of concern lies only when the outgoing element was the largest.
- We address this problem with the help of a data structure that keeps checking whether the incoming element is larger than the already present elements. This could be implemented with the help of a de-queue.

### Solution
- we are storing indexes of numbers in deque
- if our deque is not empty, then we will first check out of boundary case, i.e., we shouldn't have more than k elements in our window, hence on peeking at front, if we found i-k index, this means this element is out of boundary, so remove it
- if our deque is not empty and numbers at the last is less than current Number, then we keep on removing the numbers until it is greater than current Num
- then we add our current Number at last
- at last, if our index is greater than k-1, then we can start adding our maximums to ans array, maximum will always be at front

### Code
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

### Edge Cases
- NA

### Other Techniques
- Nested Loops

### Complexity
1. Time Complexity - O(2N)
2. Space Complexity - O(K)