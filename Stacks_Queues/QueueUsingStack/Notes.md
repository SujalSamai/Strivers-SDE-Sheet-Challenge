### Question
- Implement a Queue DS which follows FIFO property, using only the instances of Stack DS
    1. enqueue(num)
    2. dequeue()
    3. peek()
    4. isEmpty()

### Sample Input
    func=1 add=1
    func=1 add=2
    func=1 add=3
    func=2
    func=2 
    func=2
    func=3

### Sample Output
    1 
    2
    3
    -1

### Solution
- Take two stacks and initialise them
- Enqueue -> if s1 is empty, we will push the value, but if it is not then we will put all elements of s1 in s2 and pop them from s1. Now we will push our desired val in s1 and then again push back all the numbers from s2 to s1 and remove them from s2
- Dequeue -> if s1 is empty return -1, else remove the top element and return it
- Peek -> return the top element
- isEmpty -> check if s1 is empty or not

### Code
    static class Queue {
        Stack<Integer> s1;
        Stack<Integer> s2;

        Queue() {
            // Initialize your data structure here.
            s2=new Stack<>();
            s1=new Stack<>();
        }

        void enQueue(int val) {
            // Implement the enqueue() function.
            if(s1.isEmpty()){
                s1.push(val);
            }else{
                while(!s1.isEmpty()) {
                    s2.push(s1.pop());
                }
                s1.push(val);
                while(!s2.isEmpty()){
                    s1.push(s2.pop());
                }
            }
        }

        int deQueue() {
            if(s1.isEmpty()) {
                return -1;
            }
            return s1.pop();
        }

        int peek() {
            if(s1.isEmpty()){
                return -1;
            }
            return s1.peek();
        }

        boolean isEmpty() {
            return s1.isEmpty();
        }
    }

### Edge Cases
- NA

### Other Techniques
- NA

### Complexity
1. Time Complexity - O(N)
2. Space Complexity - O(N)