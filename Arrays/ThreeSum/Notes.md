### Question
- Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0. 
- Notice that the solution set must not contain duplicate triplets.

### Sample Input
    [-1,0,1,2,-1,-4]
    [0,1,1]

### Sample Output
    [[-1,-1,2],[-1,0,1]]
    []

### Solution
- Sort the array in order to easily avoid duplicate triplets
- traverse the array & if currentNum!= currentNum-1 then we take the currentElem as one of the number for our triplet
- target will be -number, as our target is 0
- now traverse to the remaining part of array, considering we got one number for the triplet
- use two pointers, if their sum=target, then add it in our result
- after that avoid duplicates
- if sum> target, then right-- else left++

### Code
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        ArrayList<List<Integer>> res=new ArrayList<>();

        for (int i=0; i<nums.length-2; i++){
            if(i==0 || (i>0 && nums[i]!=nums[i-1])){
                int target= -nums[i];
                int left=i+1;
                int right=nums.length-1;

                while (left<right){
                    if(nums[left]+ nums[right]==target){
                        ArrayList<Integer> miniSol= new ArrayList<>();
                        miniSol.add(nums[i]);
                        miniSol.add(nums[left]);
                        miniSol.add(nums[right]);
                        res.add(miniSol);

                        while (left<right && nums[left]==nums[left+1]) left++;
                        while (left<right && nums[right]==nums[right-1]) right--;
                        left++; right--;
                    }
                    else if(nums[left]+ nums[right]>target) right--;
                    else left++;
                }
            }
        }
        return res;
    }

### Edge Cases
- NA

### Other Techniques
- Nested Loops

### Complexity
1. Time Complexity - O(N^2)
2. Space Complexity - O(3K) where K is no. of triplets