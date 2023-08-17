### Question
- Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.

### Sample Input
    nums = [1,1,1,2,2,3], k = 2
    nums = [1], k = 1

### Sample Output
    [1, 2]
    [1]

### Solution
- To count the frequency of each number we will add each unique number to a Hashmap and count their frequencies
- Now we will create a min heap, which is created according to the frequencies i.e., less frequent element will be at top
- One by one we will add each map entry to our heap, the moment size of heap exceeds k, we will pop an element from heap (min element as it is a min heap)
- at the end we will be left with, top k frequent elements in the heap, insert them into an array and return it

### Code
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

### Edge Cases
- NA

### Other Techniques
- Sorting

### Complexity
1. Time Complexity - O(nlog(k))
2. Space Complexity - O(3k)