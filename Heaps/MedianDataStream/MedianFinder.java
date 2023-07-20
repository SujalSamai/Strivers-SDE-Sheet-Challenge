package Heaps.MedianDataStream;

import java.util.PriorityQueue;

public class MedianFinder {
    //maxHeap will contain elements smaller than or equal to median
    //minHeap will contain elements greater than median or equal to median
    //both of them will have almost similar size except when number of elements is odd, maxHeap will contain the median too
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
}
