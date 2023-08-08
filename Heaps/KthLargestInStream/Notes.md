### Question
- Design a class to find the kth largest element in a stream. Note that it is the kth largest element in the sorted order, not the kth distinct element. 
- Implement KthLargest class:
  - KthLargest(int k, int[] nums) Initializes the object with the integer k and the stream of integers nums. 
  - int add(int val) Appends the integer val to the stream and returns the element representing the kth largest element in the stream.

### Sample Input
    ["KthLargest", "add", "add", "add", "add", "add"]
    [[3, [4, 5, 8, 2]], [3], [5], [10], [9], [4]]

### Sample Output
    [null, 4, 5, 5, 8, 8]

### Solution
- We will use a min-heap
- In the constructor, we will add all the numbers of arr in our min heap
- In add function, we will add the given value, min heap will automatically sort the numbers and keep the smallest ones at the top
- We pop elements till size of heap > k, once size of heap==k, return top of heap
- As we only need the k largest, even if we remove the small elements, it won't effect our answer

### Code
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

### Other Techniques
- NA

### Complexity
1. Time Complexity - O(NlogK)
2. Space Complexity - O(K)