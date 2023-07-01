### Question
- Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

### Sample Input
    [100,4,200,1,3,2]
    [0,3,7,2,5,8,4,6,0,1]

### Sample Output
    4
    9

### Solution
- We will use a hashset, and add all the numbers in it
- We will maintain a maxStreak & traverse the arr
- If the currentNum is going to be the first number for the Sequence, then we will keep on checking if the next coming elements are num+1 or not
- Update maxStreak accordingly

### Code
    public static int longestConsecutiveOptimal(int[] nums){
        HashSet<Integer> set=new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int maxStreak=0;
        for (int num : nums) {
            //making sure that the number we are choosing is the first number for the sequence
            if (!set.contains(num-1)){
                int curNum=num;
                int curStreak=1;
                while (set.contains(curNum+1)){
                    curStreak++;
                    curNum++;
                }
                maxStreak= Math.max(maxStreak,curStreak);
            }
        }
        return maxStreak;
    }

### Edge Cases
- NA

### Other Techniques
- Sorting

### Complexity
1. Time Complexity - O(N)
2. Space Complexity - O(N)