### Question
- Given an integer array nums, return the length of the longest strictly increasing
  subsequence.

### Sample Input
    nums = [10,9,2,5,3,7,101,18]
    nums = [0,1,0,3,2,3]

### Sample Output
    4
    4

### Solution
- We can either take an element or not take, and for taking an element it should be greater than previous taken one
- So we will take a variable prevInd to denote prevInd taken in answer, which is initialised to -1
- Not take: when we not take an index then we add nothing to it and go to next index
- Take: when we take an index then we add 1 to our answer and move to next index. We can only take the current element, when prevInd=-1 (first el of array) or current Number > previous number
- As we need to return longest subsequence, we will take max of both the cases and return it

To memoize this code:
- Our function has two variables that are changing: ind and prev_ind.
- ‘ind’ represents the index of the array. It can range from 0 to n-1. 
- ‘prev_index’ also represents the index of the array. When we have not considered any element in our LIS, prev_index is -1. Therefore, prev_index can range from -1 to n-1. Now we cannot store the -1 index in our 2D array. Therefore, we would do a coordinate shift of one as follows: [-1,0,1,2,3..n-1] convert to [0,1,2,3,4...n], so our dp will be dp[n][n+1]
- We initialize the dp array to -1. 
- Whenever we want to find the answer to particular parameters (say f(ind,prev_index), we first check whether the answer is already calculated using the dp array(i.e dp[ind][prev_index]!= -1 ). If yes, simply return the value from the dp array. 
- If not, then we are finding the answer for the given value for the first time, we will use the recursive relation as usual but before returning from the function, we will set dp[ind][ind2] to the solution we get.

### Code
    public int lengthOfLIS(int[] nums){
        int n= nums.length;
        int[][] dp = new int[n][n+1];
        for (int[] row: dp) Arrays.fill(row, -1);
        return countLIS(nums, n, 0, -1, dp);
    }

    private int countLIS(int[] nums, int n, int ind, int prevInd, int[][] dp) {
        if (ind==n){
            return 0;
        }

        if (dp[ind][prevInd+1]!=-1) return dp[ind][prevInd+1];

        int notTake = 0 + countLIS(nums, n, ind+1,prevInd, dp);
        int take = 0;
        if (prevInd==-1 || nums[ind] > nums[prevInd]){
            take = 1 + countLIS(nums, n, ind+1, ind, dp);
        }
        return dp[ind][prevInd+1] = Math.max(notTake, take);
    }

### Edge Cases
- NA

### Other Techniques
- Kadane's Algo
- Nested Loops

### Complexity
1. Time Complexity - O(N^2)
2. Space Complexity - O(N^2)