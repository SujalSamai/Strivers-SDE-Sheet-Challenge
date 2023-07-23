### Question
- You're given a stack consisting of 'N' integers.
- Your task is to sort this stack in descending order using recursion.

### Sample Input
    stack = [5, -2, 9, -7, 3]
    stack = [-3, 14, 18, -5, 30]

### Sample Output
    [9, 5, 3, -2, -7]
    [30, 18, 14, -3, -5]

### Solution
- To sort the stack, we will one by one pop stack element and keep them in call stack until only one element is left in stack
- While returning we will go in the insert function, where we will pass the current stack and the number we popped, so that we can insert the number in its appropriate position in stack
- in insert function, if stack is empty or top of stack is less than the number, then we will directly push the number in stack
- else, we will pop the stack top, insert the number via recursion and again push the popped element back to stack

### Code
    public static void sortStack(Stack<Integer> stack) {
        if(stack.size()==1) return;
        int temp= stack.pop();
        sortStack(stack);
        insert(stack, temp);
    }

    public static void insert(Stack<Integer> stack, int num){
        if(stack.size()==0 || stack.peek()<num){
            stack.push(num);
            return;
        }
        int val= stack.pop();
        insert(stack, num);
        stack.push(val);
    }

### Edge Cases
- NA

### Other Techniques
- NA

### Complexity
1. Time Complexity - O(N^2)
2. Space Complexity - O(N)