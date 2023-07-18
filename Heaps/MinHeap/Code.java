package Heaps.MinHeap;

import static Heaps.MinHeap.Heapify.heapify;

public class Code {
    // Returns the parent node.
    static int parent(int k) {
        return (k - 1) / 2;
    }
    static int sz;

    static int[] minHeap(int n, int[][] q) {
        int size = 0;

        int[] heap = new int[n];

        // Define an array which stores the min elements.
        int tot = 0;
        for(int i=0;i<n;i++){
            if(q[i][0]==1)tot++;
        }

        int[] ans = new int[tot];
        int id = 0;

        for (int i = 0; i < n; i++) {
            // If query is of type 1 then insert the value in the heap.
            // Else take min element from the heap and append it in the ans.
            if (q[i][0] == 0) {
                sz = size;
                insert(heap, q[i][1]);
                size = sz;
            } else {
                sz = size;
                ans[id++] = extractMin(heap);
                size = sz;
            }
        }

        // Return the ans array.
        return ans;
    }

    static void insert(int[] heap, int val) {
        // Insert the val at the end of the heap.
        heap[sz] = val;

        // If There is more than 1 node in the Heap.
        // MinHeapify the heap by checking the val at its parent node.
        // Also do it until the heap property is not satisfied.
        int i = sz;
        sz += 1;

        while (i != 0 && heap[parent(i)] > heap[i]) {
            // Swap the value of current node with its parent.
            int tmp = heap[i];
            heap[i] = heap[parent(i)];
            heap[parent(i)] = tmp;
            // Check that if the parent element of current element is satisfying the heap property.
            i = parent(i);
        }
    }

    static int extractMin(int[] heap) {
        // Check if the current node is the only node in the heap.
        if (sz == 1) {
            sz -= 1;
            return heap[0];
        }

        // Takeout the min value and remove it from the heap.
        int val = heap[0];
        // Put last node on the top of heap.
        heap[0] = heap[sz - 1];
        // Decrease the size of heap as the minimum element is removed.
        sz -= 1;
        // Heapify the heap to satisfy the heap property.
        heapify(heap, 0, sz);
        return val;
    }
}
