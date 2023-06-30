### Question
- You have been given an array of size N. It only contains 0s, 1s and 2s. Write a solution to sort it.

### Sample Input
    0 1 2 2 1 0
    0 1 2 1 2 1 2

### Sample Output
    0 0 1 1 2 2
    0 1 1 1 2 2 2

### Solution
- we can use 3 pointer approach, where low, mid=0 & high=n-1
- if the mid==1 don't do anything, increase mid pointer
- if mid==0, swap mid and low i.e., move to left of 1, increase low & mid
- if mid==2, swap mid and high i.e., move to right of 1, decrease high

### Code
    public static void sort012(int[] arr){
        int low=0, mid=0;
        int high= arr.length-1;
        while (mid<=high){
            if(arr[mid]==1){
                mid++;
            }else if(arr[mid]==0){
                int temp= arr[low];
                arr[low]= arr[mid];
                arr[mid]=temp;
                low++;
                mid++;
            }else {
                int temp= arr[high];
                arr[high]= arr[mid];
                arr[mid]=temp;
                high--;
            }
        }
    }


### Complexity
1. Time Complexity - O(N)
2. Space Complexity - O(1)