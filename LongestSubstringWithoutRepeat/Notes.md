### Question
- Given a string s, find the length of the longest substring without repeating characters.

### Sample Input
    "abcabcbb"
    "bbbbb"

### Sample Output
    3
    1

### Solution
- We will use two pointers & a Hashset to check duplicate elements, and a maxAns
- initially both the pointers will point to 0
- traverse the string, at each iteration, if the character doesn't exist in the set, it means our current substring has not repeating characters, we will add it in the set and update maxAns with right-left+1 to get length of substring
- but if the character exists in the set, we will keep on removing the left element & increase left pointer till the character is not there in our substring anymore, like a sliding window algorithm
- at the end return maxAns


### Code
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0) return 0;
        HashSet<Character> set= new HashSet<>();
        int left=0;
        int maxAns= Integer.MIN_VALUE;
        for (int right=0; right<s.length(); right++){
            if(set.contains(s.charAt(right))){
                while (left<right && set.contains(s.charAt(right))){
                    set.remove(s.charAt(left));
                    left++;
                }
            }
            set.add(s.charAt(right));
            maxAns= Math.max(maxAns, right-left+1);
        }
        return maxAns;
    }

### Edge Cases
- If string's length is 0, return 0

### Other Techniques
- HashSet and nested loops

### Complexity
1. Time Complexity - O(N)
2. Space Complexity - O(N)