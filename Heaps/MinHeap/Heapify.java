package Heaps.MinHeap;

public class Heapify {
    static void heapify(int[] heap, int k, int size) {
        //left child of the node.
        int l = 2*k+1;

        //right child of the node.
        int r = 2*k+2;

        // Find the smallest element between the current node and its children.
        // Check if the left child is smallest.
        int smallest = k;
        if (l < size && heap[l] < heap[k]) {
            smallest = l;
        }

        // Check if the right node is smallest then the previous smallest.
        if (r < size && heap[r] < heap[smallest]) {
            smallest = r;
        }

        // If the smallest element is not in the current node.
        // We have to heapify the Heap to take that element to the top.
        if (smallest != k) {
            // Swap the values of current node and the smallest node value.
            int tempp = heap[k];
            heap[k] = heap[smallest];
            heap[smallest] = tempp;

            // Call the heapify function on smallest value node which now contains the value of parent node.
            heapify(heap, smallest, size);
        }
    }
}
