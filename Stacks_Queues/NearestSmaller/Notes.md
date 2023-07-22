### Question
- Given an array, find the nearest smaller element G[i] for every element A[i] in the array such that the element has an index smaller than i.
- Elements for which no smaller element exist, consider next smaller element as -1.

### Sample Input
    A = [4, 5, 2, 10, 8]
    A = [3, 2, 1]

### Sample Output
    [-1, 4, -1, 2, 2]
    [-1, -1, -1]

### Solution
- We will  take a stack and result arr
- we will then traverse the array, at each iteration we will push the current element to the stack
- Before that we will check, if stack is not empty & top of stack >= curr element, then pop from stack
- if stack is not empty & top of stack < curr element, this is our answer, update in res array
- else no smaller element present on left, store -1

### Code
    public static int[] prevSmaller(int[] A) {
        Stack<Integer> stack= new Stack<>();
        int[] res= new int[A.length];
        for (int i = 0; i < A.length; i++) {
            while (!stack.isEmpty() && stack.peek()>=A[i]){
                stack.pop();
            }
            if (!stack.isEmpty()) res[i]=stack.peek();
            else res[i]=-1;
            stack.push(A[i]);
        }
        return res;
    }

### Edge Cases
- NA

### Other Techniques
- NA

### Complexity
1. Time Complexity - O(N)
2. Space Complexity - O(N)