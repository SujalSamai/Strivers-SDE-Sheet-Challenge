### Question
- Given an array of integers heights representing the histogram's bar height where the width of each bar is 1, return the area of the largest rectangle in the histogram.

### Sample Input
    heights = [2,1,5,6,2,3]
    heights = [2,4]

### Sample Output
    10
    4

### Intuition
The idea behind this solution is to use two arrays, leftsmall and rightsmall, to store the indices of the nearest smaller bars to the left and right for each bar in the histogram. By having this information, we can calculate the width and height of a rectangle centered around each bar and find the area of the largest rectangle that can be formed within the histogram.

### Solution
- Initialize an empty stack and two arrays, leftsmall and rightsmall, to store the indices of the nearest smaller bars to the left and right for each bar, respectively.
- Traverse the histogram from left to right: For each bar, compare its height with the height of the bar at the top of the stack. 
- While the stack is not empty and the height of the current bar is < the height of the bar at the top of the stack, pop elements from the stack. For each popped element, update its rightsmall index to the current index (i.e., the index of the current bar).
- After the loop, if the stack is empty, it means there is no smaller bar to the left of the current bar, so set its leftsmall index as 0. Otherwise, set it to the index of the bar at the top of the stack plus 1. Push the current index into the stack.
- Clear the stack for reuse, and again do the similar procedure for rightSmall, but this time traverse from back side
- Now, we have the leftsmall and rightsmall arrays, which store the indices of the nearest smaller bars to the left and right for each bar. 
- Iterate through the histogram again:
  For each bar, calculate the width of the rectangle as (rightsmall[i] - leftsmall[i] + 1) and the height of the rectangle as heights[i]. 
- Compute the area of the rectangle for each bar and keep track of the maximum area found.

### Code
    public static int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack < Integer > st = new Stack < > ();
        int[] leftSmall = new int[n];
        int[] rightSmall = new int[n];
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }

            if (st.isEmpty()) leftSmall[i] = 0;
            else leftSmall[i] = st.peek() + 1;
            st.push(i);
        }

        // clear the stack to be re-used
        while (!st.isEmpty()) st.pop();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }
            if (st.isEmpty()) rightSmall[i] = n - 1;
            else rightSmall[i] = st.peek() - 1;
            st.push(i);
        }

        int maxA = 0;
        for (int i = 0; i < n; i++) {
            maxA = Math.max(maxA, heights[i] * (rightSmall[i] - leftSmall[i] + 1));
        }
        return maxA;
    }

### Edge Cases
- NA

### Other Techniques
- Nested Loops
- Single stack and single arr - More optimized

### Complexity
1. Time Complexity - O(3N)
2. Space Complexity - O(3N)