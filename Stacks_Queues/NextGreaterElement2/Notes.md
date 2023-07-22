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
- We will first push all the elements from back side into our stack

### Code
    public static int[] nextGreaterElements(int[] nums){
        Stack<Integer> st= new Stack<>();
        int[] res= new int[nums.length];

        //push all the elements of the array to stack from back side
        for(int i = nums.length - 1; i >= 0; i --) {
            st.push(nums[i]);
        }

        for (int i = nums.length-1 ; i >= 0 ; i--) {
            while (!st.isEmpty() && st.peek() <= nums[i]){
                st.pop();
            }
            if (st.isEmpty()) res[i]=-1;
            else{
                res[i]=st.peek();
            }
            st.push(nums[i]);
        }
        return res;
    }

### Edge Cases
- NA

### Other Techniques
- NA

### Complexity
1. Time Complexity - O(V), V is the amount
2. Space Complexity - O(1)