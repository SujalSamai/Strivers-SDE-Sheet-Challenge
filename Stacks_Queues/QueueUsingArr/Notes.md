### Question
- Stack is a DS that follows FIFO principle.
- Design and implement a stack along with the given functions:
    1. Enqueue(add)
    2. Dequeue()

### Sample Input
    func=1 add=2
    func=1 add=7
    func=2
    func=1 add=13
    func=2
    func=2
    func=2

### Sample Output
    2 7 13 -1

### Solution
- In Enqueue, add element to rear side of arr and increment rear
- In dequeue, if queue is empty return -1, else remove from front side of arr

### Code
    static class Queue {
        int front, rear;
        int []arr;

        Queue() {
            front = 0;
            rear = 0;
            arr = new int[100001];
        }

        // Enqueue (add) element 'e' at the end of the queue.
        public void enqueue(int e) {
            arr[rear]=e;
            rear++;
        }

        // Dequeue (retrieve) the element from the front of the queue.
        public int dequeue() {
            if (front==rear){
                return -1; //Queue is empty
            }else{
                int x = arr[front];
                front++;
                return x;
            }
        }
    }

### Edge Cases
- NA

### Other Techniques
- NA

### Complexity
1. Time Complexity - O(1)
2. Space Complexity - O(N)