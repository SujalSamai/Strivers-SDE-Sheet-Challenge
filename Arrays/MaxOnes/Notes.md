### Question
- Given a binary array nums, return the maximum number of consecutive 1's in the array.

### Sample Input
    [1,1,0,1,1,1]
    [1,0,1,1,0,1]

### Sample Output
    3
    2

### Solution
- simply traverse the array and add each element in sum variable
- since, we need to count only 1, so we can return it from sum too
- check if the current sum is > max, & update max accordingly
- if the current element is not zero, make sum=0, as we need consecutive 1's


### Code
    public int findMaxConsecutiveOnes(int[] arr) {
        int max=0;
        int sum=0;
        for(int i=0; i<arr.length; i++){
            if(arr[i]!=0){
                sum+=arr[i];
                if(sum>max){
                    max=sum;
                }
            }else{
                sum=0;
            }
        }
        return max;
    }

### Edge Cases
- NA

### Other Techniques
- NA

### Complexity
1. Time Complexity - O(N)
2. Space Complexity - O(1)