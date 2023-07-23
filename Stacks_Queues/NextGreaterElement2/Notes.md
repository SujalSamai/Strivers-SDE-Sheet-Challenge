### Question
- Given a circular integer array nums (i.e., the next element of nums[nums.length - 1] is nums[0]), return the next greater number for every element in nums. 
- The next greater number of a number x is the first greater number to its traversing-order next in the array, which means you could search circularly to find its next greater number. If it doesn't exist, return -1 for this number.

### Sample Input
    nums = [1,2,1]
    nums = [1,2,3,4,3]

### Sample Output
    [2,-1,2]
    [2,3,4,-1,4]

### Solution
- We will need a stack, and a result arr
- If we didn't have a circular arr, we can simply traverse from back side and check:
  - if stack.top()<=currEl, pop and insert currEl
  - if stack.top()>currEl, then this is answer for currEl, update res[i]
  - else res[i]=-1
- In this question, we have a circular arr, so we can just double the existing array and do the exact same thing, we did above
  - For eg-> arr=[1,2,3,4,3], we will make it arr=[1,2,3,4,3,1,2,3,4,3] and again traverse from back side, answers of last n elements doesn't matter, we just need the first n elements
- Now, if we simply copy array, that will need extra space, instead of that, we can traverse from 2*n-1 that is double length but, instead of using nums[i] as currEl, we will use nums[i%n] as currEl
  - So for eg-> arr=[1,2,3,4,3,1,2,3,4,3], if we check the 6th index, its actually same as nums[i%n] i.e., nums[6%5]=nums[1]

### Code
    public static int[] nextGreaterElements(int[] nums){
        int n=nums.length;
        Stack<Integer> st= new Stack<>();
        int[] res= new int[n];

        for(int i= 2*n-1; i>=0; i--){
            while (!st.isEmpty() && st.peek()<=nums[i%n]){
                st.pop();
            }
            if (i<n){
                if (!st.isEmpty()){
                    res[i]=st.peek();
                }else{
                    res[i]=-1;
                }
            }
            st.push(nums[i%n]);
        }
        return res;
    }

### Edge Cases
- NA

### Other Techniques
- Nested Loops

### Complexity
1. Time Complexity - O(N)
2. Space Complexity - O(N)