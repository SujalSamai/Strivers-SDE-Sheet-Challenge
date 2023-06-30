### Question
- You are given an array consisting of N integers. Your have to find the sum of the subarray having the maximum sum.

### Sample Input
    9
    1 2 7 -4 3 2 -10 9 1
    6
    10 20 -30 40 -50 60

### Sample Output
    11
    60

### Solution
- Maintain curSum=0 & maxSum= arr[0]
- traverse the array, and add curElem to curSum
- Now if curSum is negative, then it can't become maximum in any way so make it 0
- now, make maxSum as max of curSum & maxSum

### Code
    public static long maxSubarraySum(int[] arr, int n) {
		long curSum=0, maxSum= arr[0];
        for (int i = 0; i < n; i++) {
            curSum+=arr[i];
			if(curSum<0){
                curSum=0;
            }
            maxSum= Math.max(curSum, maxSum);
        }
        return maxSum;
	}


### Complexity
1. Time Complexity - O(N)
2. Space Complexity - O(1)