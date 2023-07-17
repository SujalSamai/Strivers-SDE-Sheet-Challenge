### Question
- You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once. 
- Return the single element that appears only once. 
- Your solution must run in O(log n) time and O(1) space.

### Sample Input
    [1,1,2,3,3,4,4,8,8]
    [3,3,7,7,10,11,11]

### Sample Output
    2
    10

### Solution
- To reduce additional edge cases we handled first and last element separately
- If we see this example -> [1,1,2,2,3,3,4,5,5,6,6], 4 is our answer, numbers before it are in couple and their indexes are (even, odd) & after 4, the index of the numbers are in (odd, even) pair.
- We will find mid in search space and check its prev and next element initially, if both are not equal then that is the single element
- Otherwise, we will check if the index of mid is even or odd
  - if index is odd && its prev element is equal or index is even && next element is equal, then we are in left side of single element, then we will eliminate this side and search in the right side
  - else, we are in right side of single element, so eliminate this side and search in left part

### Code
    public static int singleNonDuplicate(int[] nums){
        int n=nums.length;
        if (n==1) return nums[0];
        if (nums[0]!=nums[1]) return nums[0];
        if (nums[n-1]!=nums[n-2]) return nums[n-1];

        int low=1, high=n-2;
        while (low<=high){
            int mid= (low+high)/2;
            if (nums[mid]!= nums[mid+1] && nums[mid]!=nums[mid-1]){
                return nums[mid];
            }

            //we are in left side of the single element
            if ((mid%2 == 1 && nums[mid]==nums[mid-1]) || (mid%2 == 0 && nums[mid]==nums[mid+1])){
                low=mid+1;
            }
            //right side of single element
            else{
                high=mid-1;
            }
        }
        return -1;
    }    

### Edge Cases
- For first and last element we would need additional edge cases, so we wrote them separately and reduced the search space

### Other Techniques
- Linear Traversal and check prev and next element for each number
- XOR

### Complexity
1. Time Complexity - O(logN)
2. Space Complexity - O(1)