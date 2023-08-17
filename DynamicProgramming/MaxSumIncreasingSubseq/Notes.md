### Question
- Given an array of n positive integers. Find the sum of the maximum sum subsequence of the given array such that the integers in the subsequence are sorted in strictly increasing order i.e. a strictly increasing subsequence.

### Sample Input
    N = 5, arr[] = {1, 101, 2, 3, 100} 
    N = 3, arr[] = {1, 2, 3}

### Sample Output
    106
    6

### Intuition
- Exactly Same as Longest Increasing Subsequence

### Solution
- We can either take an element or not take, and for taking an element it should be greater than previous taken one
- So we will take a variable prevInd to denote prevInd taken in answer, which is initialised to -1
- Not take: when we not take an index then we add nothing to it and go to next index
- Take: when we take an index then we add currentValue to our answer and move to next index. We can only take the current element, when prevInd=-1 (first el of array) or current Number > previous number
- As we need to return max increasing subsequence, we will take max of both the cases and return it

To memoize this code:
- Our function has two variables that are changing: ind and prev_ind.
- ‘ind’ represents the index of the array. It can range from 0 to n-1.
- ‘prev_index’ also represents the index of the array. When we have not considered any element in our MIS, prev_index is -1. Therefore, prev_index can range from -1 to n-1. Now we cannot store the -1 index in our 2D array. Therefore, we would do a coordinate shift of one as follows: [-1,0,1,2,3..n-1] convert to [0,1,2,3,4...n], so our dp will be dp[n][n+1]
- We initialize the dp array to -1.
- Whenever we want to find the answer to particular parameters (say f(ind,prev_index), we first check whether the answer is already calculated using the dp array(i.e dp[ind][prev_index]!= -1 ). If yes, simply return the value from the dp array.
- If not, then we are finding the answer for the given value for the first time, we will use the recursive relation as usual but before returning from the function, we will set dp[ind][ind2] to the solution we get.

### Code
    //Memoization
    public int maxSumIS(int arr[], int n) {
        int[][] dp = new int[n][n+1];
        for (int[] row: dp) Arrays.fill(row, -1);
        return getMaxSum(arr, n, 0, -1, dp);
    }

    private int getMaxSum(int[] arr, int n, int ind, int prev, int[][] dp) {
        if (ind==n) return 0;
        if (dp[ind][prev+1]!=-1) return dp[ind][prev+1];

        int notTake = 0 + getMaxSum(arr, n, ind+1, prev, dp);
        int take = 0;
        if (prev==-1 || arr[ind] > arr[prev]){
            take = arr[ind] + getMaxSum(arr, n, ind+1, ind, dp);
        }

        return dp[ind][prev+1] = Math.max(take, notTake);
    }

    //Tabulation
    public static int maxSumISTabulation(int[] arr, int n){
        int[][] dp= new int[n+1][n+1];
        for (int ind=n-1; ind>=0; ind--){
            for (int prev = ind-1; prev >= -1 ; prev--) {
                int take =0;
                if (prev==-1 || arr[ind]>arr[prev]){
                    take = arr[ind] + dp[ind+1][ind+1];
                }
                int notTake = 0 + dp[ind+1][prev+1];
                dp[ind][prev+1] = Math.max(take, notTake);
            }
        }
        return dp[0][0];
    }

### Edge Cases
- NA

### Other Techniques
- Kadane's Algo
- Nested Loops

### Complexity
1. Time Complexity - O(N^2)
2. Space Complexity - O(N^2)