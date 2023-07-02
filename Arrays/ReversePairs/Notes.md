### Question
- Given an integer array nums, return the number of reverse pairs in the array. 
- A reverse pair is a pair (i, j) where:
  - 0 <= i < j < nums.length and 
  - nums[i] > 2 * nums[j].

### Sample Input
    [1,3,2,3,1]
    [2,4,3,5,1]

### Sample Output
    2
    3

### Solution
- Similar totally to merge sort
- Only these lines make all the difference


    for (int i = low; i <= mid ; i++) {
        while (j<=high && nums[i]> 2*(long)nums[j]){
            j++;
        }
        count += j - (mid+1);
    }
- it counts all the elements that are eligible to make pairs

### Code
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length-1);
    }

    private int mergeSort(int[] nums, int low, int high) {
        int count=0;
        if (low>=high) return count;
        int mid= (low+high)/2;
        count += mergeSort(nums, low, mid);
        count += mergeSort(nums, mid+1, high);
        count += merge(nums, low, mid, high);
        return count;
    }

    private int merge(int[] nums, int low, int mid, int high) {
        int count=0;
        int j= mid+1;
        for (int i = low; i <= mid ; i++) {
            while (j<=high && nums[i]> 2*(long)nums[j]){
                j++;
            }
            count += j - (mid+1);
        }

        ArrayList<Integer> temp=new ArrayList<>();
        int left=low, right=mid+1;
        while (left<=mid && right<=high){
            if (nums[left]<nums[right]){
                temp.add(nums[left]);
                left++;
            }else{
                temp.add(nums[right]);
                right++;
            }
        }
        while (left<=mid){
            temp.add(nums[left]);
            left++;
        }
        while (right<=high){
            temp.add(nums[right]);
            right++;
        }

        for (int i = low; i <= high; i++) {
            nums[i]= temp.get(i-low);
        }
        return count;
    }

### Edge Cases
- NA

### Other Techniques
- Brute-force - nested loops

### Complexity
1. Time Complexity - O(2*NlogN)
2. Space Complexity - O(N)