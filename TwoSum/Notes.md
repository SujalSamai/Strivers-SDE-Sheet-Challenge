### Question
- Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target. 
- You may assume that each input would have exactly one solution, and you may not use the same element twice. 
- You can return the answer in any order.

### Sample Input
    nums=[2, 7, 11, 15] target=9
    nums=[3,2,4] target=6

### Sample Output
    9
    6

### Solution
- We will use hashmap to store target-element along with its index for each iteration
- if at any point the current element exists in the map, that means, another element exist adding which we can get to the target
- Return both of the element's index

### Code
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map= new HashMap<>();
        for (int i=0; i< nums.length; i++){
            if(map.containsKey(nums[i])){   //checks if num[i] is already added in map
                return new int[]{map.get(nums[i]),i};
            }
            map.put(target-nums[i],i);  //keeps adding target-num[i] in the map
            //if array has element which will help in achieving the target then, target-nums[i] will definitely be present in the array
        }
        return new int[0];
    }

### Edge Cases
- NA

### Other Techniques
- Brute Force - nested loops

### Complexity
1. Time Complexity - O(N)
2. Space Complexity - O(N)