### Question
- Write a function to find the longest common prefix string amongst an array of strings. 
- If there is no common prefix, return an empty string "".

### Sample Input
    strs = ["flower","flow","flight"]
    strs = ["dog","racecar","car"]

### Sample Output
    "fl"
    ""

### Solution
- We will traverse the first string only, as there is no need for further checking (as we need to find common prefix)
- In the loop, traverse each string of strs and check, if our i==s.length() i.e, we have traversed the whole string or currentChar != character at string 1 -> return res
- else append the current character of string 1 into our res

### Code
    public String longestCommonPrefix(String[] strs) {
        StringBuilder res = new StringBuilder();
        
        for(int i = 0; i < strs[0].length(); i++) {
            //for every string
            for(String s: strs){
                //if the current char in the particular string is not equal to the one in the first string, return
                if(i == s.length() || s.charAt(i) != strs[0].charAt(i))
                    return res.toString();
            }
            //if the current char is present in all strings, append it
            res.append(strs[0].charAt(i));
        }
        return res.toString();
    }

### Edge Cases
- NA

### Other Techniques
- NA

### Complexity
1. Time Complexity - O(N*M), where N is length of one string and M is the length of prefix
2. Space Complexity - O(M)