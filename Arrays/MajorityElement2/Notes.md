### Question
- Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.

### Sample Input
    [3,2,3]
    [1]

### Sample Output
    [3]
    [1]

### Solution
- Uses Moore's Voting Algorithm
- If count1 or count2=0 then we mark num2 & num2 as the current number, & make their counts as 1
- if current number is equal to num1 or num2, increase their respective counts
- else decrement counts (different numbers cancelling each other out)
- now we got our candidates for majority elements in num1 & num2. make both their counts as 0
- now traverse the arr & increase the count everytime number is equal to num1 or num2
- check if counts are greater than n/3 and return answer

### Code
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if(nums.length == 0) return res;

        int num1 = -1;
        int num2 = -1;
        int count1 = 0;
        int count2 = 0;

        for (int val : nums) {
            if(val == num1)
                count1++;
            else if (val == num2)
                count2++;
            else if (count1 == 0) {
                num1 = val;
                count1=1;
            }
            else if (count2 == 0) {
                num2 = val;
                count2=1;
            }
            else {
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;
        for(int val : nums) {
            if(val == num1)
                count1++;
            else if(val == num2)
                count2++;
        }
        if(count1 > nums.length/3)
            res.add(num1);
        if(count2 > nums.length/3)
            res.add(num2);
        return res;
    }

### Edge Cases
- NA

### Other Techniques
- Brute-force - nested loops
- Hashing

### Complexity
1. Time Complexity - O(2*N)
2. Space Complexity - O(1)