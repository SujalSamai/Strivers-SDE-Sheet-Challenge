### Question
- There is an integer array nums sorted in ascending order (with distinct values). 
- Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2]. 
- Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums. 
- You must write an algorithm with O(log n) runtime complexity.

### Sample Input
    nums = [4,5,6,7,0,1,2], target = 0
    nums = [4,5,6,7,0,1,2], target = 3

### Sample Output
    4
    -1

### Solution
- Though the array is rotated, we can clearly notice that for every index, one of the 2 halves will always be sorted.
- First, we identify the sorted half of the array. 
- Once found, we determine if the target is located within this sorted half. 
- If not, we eliminate that half from further consideration. 
- Conversely, if the target does exist in the sorted half, we eliminate the other half.
- If arr[low] <= arr[mid]: This condition ensures that the left part is sorted. 
  - If arr[low] <= target && target <= arr[mid]: It signifies that the target is in this sorted half. So, we will eliminate the right half (high = mid-1). 
  - Otherwise, the target does not exist in the sorted half. So, we will eliminate this left half by doing low = mid+1. 
- Otherwise, if the right half is sorted:
  - If arr[mid] <= target && target <= arr[high]: It signifies that the target is in this sorted right half. So, we will eliminate the left half (low = mid+1). 
  - Otherwise, the target does not exist in this sorted half. So, we will eliminate this right half by doing high = mid-1.

### Code
    public static int search(int[] nums, int target){
        int n= nums.length;
        int low=0, high=n-1;
        while (low<=high){
            int mid= (low+high)/2;
            if (nums[mid]==target){
                return mid;
            }

            //left part is sorted
            if (nums[low]<= nums[mid]){
                //number is in the left side only
                if (nums[low]<= target && target<=nums[mid]){
                    high=mid-1;
                }else{
                    //number is in the right side
                    low= mid+1;
                }
            }
            //right part is sorted
            else{
                //number is in the right side only
                if (nums[mid]<=target && target<= nums[high]){
                    low= mid+1;
                }else{
                    //number is in the left side
                    high=mid-1;
                }
            }
        }
        return -1;
    }  

### Edge Cases
- NA

### Other Techniques
- Linear Search

### Complexity
1. Time Complexity - O(logN)
2. Space Complexity - O(1)