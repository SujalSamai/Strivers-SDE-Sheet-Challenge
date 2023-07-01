### Question
- Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:
  - 0 <= a, b, c, d < n 
  - a, b, c, and d are distinct. 
  - nums[a] + nums[b] + nums[c] + nums[d] == target
- You may return the answer in any order.

### Sample Input
    nums = [1,0,-1,0,-2,2], target = 0
    nums = [2,2,2,2,2], target = 8

### Sample Output
    [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
    [[2,2,2,2]]

### Solution
- Sort the array, to keep check on the duplicates & to search easily
- traverse the array, skip duplicates & find the four distinct elements that sum up to become target

### Code
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> quadruplets = new ArrayList<>();
        int n = nums.length;
        // Sorting the array
        Arrays.sort(nums);
        for (int i = 0; i < n - 3; i++) {
            // Skip duplicates
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < n - 2; j++) {
                // Skip duplicates
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int left = j + 1;
                int right = n - 1;
                while (left < right) {
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum < target) {
                        left++;
                    } else if (sum > target) {
                        right--;
                    } else {
                        quadruplets.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        // Skip duplicates
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        left++;
                        right--;
                    }
                }
            }
        }
        return quadruplets;
    }

### Edge Cases
- NA

### Other Techniques
- Brute Force - 4 nested loops & hashset
- Better - 3 nested loops & hashset

### Complexity
1. Time Complexity - O(N^3)
2. Space Complexity - O(4)