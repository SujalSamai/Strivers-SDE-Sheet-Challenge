### Question
- You have been "K" different lists, which are sorted individually.
- You need to merge all the given lists such that the output list should be sorted

### Sample Input
    {{3,5,9}, {1,2,3,8}}, k = 2
    {{1,5,9}, {45,90}, {2,6,78,100,234}} k=3

### Sample Output
    {1,2,3,3,5,8,9}
    {0,1,2,5,6,9,45,78,90,100,234}

### Solution
- We will create a min heap to get the minimum element from all the arrays each time and add it to our answer list
- first of all add all the first indices of each array in our heap, make sure to store its index and also index of its next element(initially 0)
- then we will run a loop till our heap is empty, as it is a min heap, the smallest one of the first 3 indices will be the smallest one, add it to our answer
- then check if this particular array has next element, if yes add it to our heap and repeat the steps

### Code
    static class Pair {
        public int first, second, third;
        Pair(int first, int second, int third) {
            this.first = first;
            this.second = second;
            this.third = third;
        }
    }


    // Implements Comparator interface for min-heap.
    static class PqComparator implements Comparator<Pair> {
        public int compare(Pair pair1, Pair pair2) {
            if (pair1.first < pair2.first) return -1;
            if (pair1.first == pair2.first) return 0;
            else return 1;
        }
    }

    public static ArrayList<Integer> mergeKSortedArrays(ArrayList<ArrayList<Integer>> kArrays, int k) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        // Create a min heap to store atmost k heap nodes at a time.
        PriorityQueue<Pair> minHeap = new PriorityQueue < Pair>(new PqComparator());

        //add the first element from each array, their index no and index of the next number
        for (int i = 0; i < kArrays.size(); i++) {
            minHeap.add(new Pair( kArrays.get(i).get(0), i, 0 ));
        }

        while (!minHeap.isEmpty()) {
            // Remove the minimum element from the heap.
            Pair curr = minHeap.remove();

            // i is the array number and j is the index of the removed element in the ith array.
            int i = curr.second;
            int j = curr.third;

            // Add the removed element to the output array.
            result.add(curr.first);

            // If the next element of the extracted element exists, add it to the heap.
            if (j + 1 < kArrays.get(i).size()) {
                minHeap.add(new Pair( kArrays.get(i).get(j + 1),  i, j + 1 ));
            }
        }
        return result;
    }

### Edge Cases
- NA

### Other Techniques
- Sort two arrays, then sort the next one with this ans so on..

### Complexity
1. Time Complexity - O(nlog(k))
2. Space Complexity - O(3k)