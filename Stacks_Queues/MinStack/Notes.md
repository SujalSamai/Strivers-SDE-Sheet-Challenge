### Question
- Design a stack that supports push, pop, top, and retrieving the minimum element in constant time. 
- Implement the MinStack class:
  - MinStack() initializes the stack object. 
  - void push(int val) pushes the element val onto the stack. 
  - void pop() removes the element on the top of the stack. 
  - int top() gets the top element of the stack. 
  - int getMin() retrieves the minimum element in the stack.
- You must implement a solution with O(1) time complexity for each function.

### Sample Input
    ["MinStack","push","push","push","getMin","pop","top","getMin"]
    [[],[-2],[0],[-3],[],[],[],[]]

### Sample Output
    [null,null,null,null,-3,null,0,-2]

### Solution
- We will take two stacks, one stack which will do operations exactly the way stack works and other one which will only take care of the min element
- push(): we push the val in stack, now we find the min element among the top of minStack and given val, whichever is small push that into minStack
- pop(): pop from both the stacks
- top(): peek into stack
- getMin(): peek into MinStack

### Code
    private Stack<Integer> stack;
    private Stack<Integer> minStack;
    public MinStack() {
        stack=new Stack<>();
        minStack= new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        if (!minStack.isEmpty()){
            val = Math.min(val, minStack.peek());
        }
        minStack.push(val);
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

### Edge Cases
- NA

### Other Techniques
- NA

### Complexity
1. Time Complexity - O(1)
2. Space Complexity - O(N)