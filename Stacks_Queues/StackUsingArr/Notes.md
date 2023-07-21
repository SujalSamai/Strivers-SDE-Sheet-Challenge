### Question
- Stack is a DS that follows LIFO principle.
- Design and implement a stack along with the given functions:
    1. Push(num)
    2. Pop()
    3. Top()
    4. isEmpty()
    5. isFull()

### Sample Input
    cap=2 
    func=1 num=1
    func=1 num=2
    func=2
    func=3
    func=4
    func=5

### Sample Output
    2 
    1
    0
    0

### Solution
- We create an array with given capacity and top=-1 initially
- if capacity- top >1, i.e., arr is not full then push element to the top and increment top
- if top>=0 i.e., when atleast 1 element is present then pop element and decrease top
- if atleast 1 element is present return top
- if top==-1, stack is empty, and if top=cap-1 stack is full

### Code
    static class Stack {
        int[] st;
        int top;
        int cap;
        Stack(int capacity) {
            this.top=-1;
            st=new int[capacity];
            this.cap = capacity;
        }
        public void push(int num) {
            if(cap-top > 1){
                top++;
                st[top]= num;
            }
        }
        public int pop() {
            if (top>=0){
                int x = st[top];
                top--;
                return x;
            }else return -1;
        }
        public int top() {
            if (top>=0){
                return st[top];
            }else return -1;
        }
        public int isEmpty() {
            if (top==-1) return 1;
            else return 0;
        }
        public int isFull() {
            if (top==cap-1) return 1;
            else return 0;
        }
    }

### Edge Cases
- NA

### Other Techniques
- NA

### Complexity
1. Time Complexity - O(N)
2. Space Complexity - O(N)