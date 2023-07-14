### Question
- Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.

### Sample Input
    [1,2,3]
    [0,1]

### Sample Output
    [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
    [[0,1],[1,0]]

### Solution
- we will traverse the array one by one, for each element, we will swap all the elements in the array with it (this way we will make sure that each number gets to be the starting number of the permutation)
- do the same process on next index with recursion calls
- whenever we go out of bound i.e. ind==nums.length, create a new list add all the numbers in it, and add it to our answer list
- while going back, swap back the elements to make them like the original array

### Code
    public static List<List<Integer>> permute(int[] nums){
        List<List<Integer>> ans=new ArrayList<>();
        recurPermutation(0,nums,ans);
        return ans;
    }

    private static void recurPermutation(int ind, int[] nums, List<List<Integer>> ans) {
        if (ind==nums.length){
            List<Integer> ds=new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                ds.add(nums[i]);
            }
            ans.add(new ArrayList<>(ds));
            return;
        }

        for (int i = ind; i < nums.length; i++) {
            swap(i, ind, nums);
            recurPermutation(ind+1, nums, ans);
            swap(i, ind, nums);
        }
    }

    private static void swap(int i, int j, int[] nums) {
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }

### Other Techniques
- Extra array for storing if index is visited

### Complexity
1. Time Complexity - O(N! * N)
2. Space Complexity - O(1)