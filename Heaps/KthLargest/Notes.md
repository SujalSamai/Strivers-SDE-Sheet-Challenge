### Question
- Given an integer array nums and an integer k, return the kth largest element in the array. 
- Note that it is the kth largest element in the sorted order, not the kth distinct element. 
- Can you solve it without sorting?

### Sample Input
    nums = [3,2,1,5,6,4], k = 2
    nums = [3,2,3,1,2,4,5,5,6], k = 4

### Sample Output
    5
    4

### Solution
- The idea is to construct a min-heap of elements. Since the top element of the min heap is the smallest element of the heap, we will keep on adding element one by one
- as soon as length of heap exceeds k, we will pop an element (which will be the smallest one)
- when the traversal will be over, return top element (that will be the kth largest)

### Code
    public int findKthLargest(int[] nums, int k){
      PriorityQueue<Integer> pq= new PriorityQueue<>();
      for(int n: nums){
        pq.add(n);
        if (pq.size()>k){
          pq.poll();
        }
      }
      return pq.peek();
    }   

### Edge Cases
- NA

### Other Techniques
- Sorting

### Complexity
1. Time Complexity - O(nlog(k))
2. Space Complexity - O(1)