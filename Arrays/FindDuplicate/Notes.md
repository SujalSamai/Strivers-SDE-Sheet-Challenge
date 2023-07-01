### Question
- Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive. 
- There is only one repeated number in nums, return this repeated number. 
- You must solve the problem without modifying the array nums and uses only constant extra space.

### Sample Input
    [1,3,4,2,2]
    [3,1,3,4,2]

### Sample Output
    2
    3

### Solution
- As there is a duplicate number present, then it'll definitely form a cycle
- we will traverse the fast & slow ptr in the circle, till they are equal
- when they are equal point fast to the first element, & start traversing both the ptrs one by one
- the point where they meet is the duplicate element

### Code
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];
        //just means slow=slow.next & fast=fast.next.next
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        // Find the "entrance" to the cycle.
        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return fast;
    }

### Edge Cases
- NA

### Other Techniques
- Hashing
- Sorting

### Complexity
1. Time Complexity - O(N)
2. Space Complexity - O(1)