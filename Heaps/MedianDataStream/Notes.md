### Question
- The median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value, and the median is the mean of the two middle values.
- Implement the MedianFinder class:
  - MedianFinder() initializes the MedianFinder object. 
  - void addNum(int num) adds the integer num from the data stream to the data structure. 
  - double findMedian() returns the median of all elements so far. Answers within 10-5 of the actual answer will be accepted.
  
### Sample Input
    ["MedianFinder", "addNum", "addNum", "findMedian", "addNum", "findMedian"]
    [[], [1], [2], [], [3], []]

### Sample Output
    [null, null, null, 1.5, null, 2.0]

### Solution
- As we need to find median, which is actually the middle element in a series of number, we know that numbers to left of median will be less than median, and number to right of median will be greater than median
- Also total no. of elements to left = total no. of elements to right. If total elements are odd then we will keep the median to left
- If total elements are odd, we will return the largest from left, but if elements are even we will find average of largest from left (need maxHeap) & smallest from right (need minHeap)
- MedianFinder will initialise two heaps, one maxHeap(left side), another minHeap(right side)
- addNum function will check is maxHeap is empty or top element in maxHeap is >= current Number(as we need small numbers to left side i.e., in maxHeap), if yes then it will add the number to maxHeap else to minHeap
- now we will check the heap sizes, if size of maxHeap exceeds, minHeap size+1, then pop from maxHeap and add it to the minHeap, else do vice versa. (if both size are equal then don't do anything)
- lastly findMedian, will check if both heap sizes are same, means total elements are even so give average, else return the top of maxHeap

### Code
    private PriorityQueue<Integer> maxHeap; //small elements - maxHeap
    private PriorityQueue<Integer> minHeap; //large elements - minHeap

    public MedianFinder(){
        maxHeap = new PriorityQueue<>((a, b) -> b - a);
        minHeap = new PriorityQueue<>((a, b) -> a - b);
    }

    public void addNum(int num){
        if (maxHeap.isEmpty() || maxHeap.peek() >= num){
            maxHeap.add(num);
        }else{
            minHeap.add(num);
        }

        //either both heaps will have equal no. of elements(even count) or maxHeap will have one extra element (odd count)
        if (maxHeap.size()>minHeap.size()+1){
            minHeap.add(maxHeap.poll());
        }
        else if (maxHeap.size()< minHeap.size()){
            maxHeap.add(minHeap.poll());
        }

    }

    public double findMedian(){
        if(maxHeap.size()== minHeap.size()){
            return (double) (minHeap.peek()+maxHeap.peek())/2;
        }
        return (double) maxHeap.peek();
    }

### Edge Cases
- NA

### Other Techniques
- Sort two arrays, then sort the next one with this ans so on..

### Complexity
1. Time Complexity - O(logn) for addNum and O(1) for findMedian and initialisation
2. Space Complexity - O(N) for heaps