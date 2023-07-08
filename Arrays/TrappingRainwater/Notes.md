### Question
- Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

### Sample Input
    [0,1,0,2,1,0,1,3,2,1,2,1]
    [4,2,0,3,2,5]

### Sample Output
    6
    9

### Solution
- If we look carefully, then we will find that we can fill water, only when height[left]<height[right]
- if we take the case when height[l]<=height[r] we increase l++, so we can surely say that there is a block with a height more than height[l] to the right of l. And for the same reason when height[r]<=height[l] we can surely say that there is a block to the left of r which is at least of height[r]
- take two pointers high1, high2 to check the highest building at both sides
- if high1<high2, increase the left pointer & find the highest till now in the left side and add to total accordingly
- else, decrease left pointer & find the highest till now in right side and add to total accordingly

### Code
    public static int trap(int[] arr){
        int total=0;
        int left=0;
        int right= arr.length-1;
        int high1=arr[left];
        int high2= arr[right];

        while (left<right){
            if (high1<high2){
                left++;
                high1= Math.max(high1, arr[left]);
                total+= high1 - arr[left];
            }else{
                right--;
                high2= Math.max(high2, arr[right]);
                total+= high2 - arr[right];
            }
        }
        return total;
    }

### Other Solutions
- Nested Loops
- Prefix and Suffix Array

### Complexity
1. Time Complexity - O(N)
2. Space Complexity - O(1)