### Question
- Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same. Then return the number of unique elements in nums.

### Sample Input
    nums = [1,1,2]
    nums = [0,0,1,1,1,2,2,3,3,4]

### Sample Output
    2
    5

### Solution
- We will check the element while traversing the array
- if current!=current+1, increment counter, and replace the current element to the next one

### Code
    public static int removeDuplicates(int[] arr){
        int count=0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[count]!=arr[i]){
                count++;
                arr[count]=arr[i];
            }
        }
        return count+1;
    }

### Edge Cases
- NA

### Other Techniques
- Hashset

### Complexity
1. Time Complexity - O(N)
2. Space Complexity - O(1)