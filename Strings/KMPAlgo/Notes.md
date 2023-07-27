### Question
- You're given two strings. 'text' of length 'n' and 'pattern' of length 'm', consisting of lowercase characters
- find all occurrences of the string 'pattern' in text
- for each occurrence, print the index from where it starts in the string 'text'(1-indexed)

### Sample Input
    text= cxyzghxyzvjkxyz,  pattern= xyz
    text= ababacabab,  pattern= aba

### Sample Output
    2 7 13
    1 3 7

### How it works
- The basic idea of the Knuth-Morris-Pratt algorithm is that in case of a mismatch, we need not check the entire ‘pattern’ string from the beginning. For this, we will create an LPS array of ‘pattern’. 
- LPS(Longest Prefix Suffix) is an array data structure that captures the length of the longest proper prefix which is also a proper suffix for every substring. Proper prefix means a prefix that is not equal to the actual string. 
- For example: Let ‘pattern’ = “abaabc” 
  - For “a”, there is no proper prefix. Therefore LPS of “a” is 0. 
  - For “ab”, proper prefix = [“a”] and proper suffix = [“b”]. Therefore LPS of “ab” is also 0. 
  - For “aba”, proper prefix = [“a”, “ab”] and proper suffix = [“a”, “ba”]. Therefore LPS of “aba” is 1 because “a” is common. 
  - For “abaa”, proper prefix = [“a”, “ab”, “aba”] and proper suffix = [“a”, “aa”, “baa”]. Therefore LPS of “abaa” is also 1. 
  - For “abaab”, proper prefix = [“a”, “ab”, “aba”, “abaa”] and proper suffix = [“b”, “ab”, “aab”, “baab”]. Therefore LPS of “abaab” is 2 because “ab” is the longest common prefix that is also suffix. 
  - For “abaabc”, proper prefix = [“a”, “ab”, “aba”, “abaa”, “abaab”] and proper suffix = [“c”, “bc”, “abc”, “aabc”, “baabc”]. Therefore LPS of “abaabc” is 0. 
  - So our final lps array is: [0, 0, 1, 1, 2, 0].

- Now when we will compare our strings, whenever we find a mismatch, instead of assigning the current variable pointer of ‘pattern’ as 0, we will assign it to the previous lps value, if possible. We will never decrement the variable pointer of ‘text’, so effectively the time complexity of this algorithm is almost linear.

### Solution
- Basically in lps, we are storing the position where we have previously encountered this current prefix. For eg-> if we have [a,b,a,a,b,a], its lps->[0,0,1,0,2,3]. In 2nd index, we have encountered a prefix in 0th index so we need to now check 1st index for pattern matching, in 3rd index, b should have been there but it isn't so, we will again check from 0th index for pattern matching
- We first find the lps array for our pattern
- after that we will traverse the text:
  - if text[i]==pattern[j] -> increment both i & j, if j==pattern length, then we will add the starting index to our answer, and shift our j pointer back to lps[j-1]
  - else:
    - if j>0 then we will directly shift j to lps[j-1]
    - else do i++ (we were at first index & it is not in our string matching answer)

### Code
    public static List< Integer > stringMatch(String text, String pattern) {
        int n = text.length(), m = pattern.length();
        List<Integer>ans=new ArrayList<>();
        int[] LPS=new int[m];
        int len = 0;
        for(int i = 1; i < m; i++){
            if(pattern.charAt(i) == pattern.charAt(len)){
                len++;
                LPS[i] = len;
            } else{
                if(len != 0){
                    len = LPS[len-1];
                }
            }
        }
        int i = 0, j = 0;
        while(i < n){
            if(text.charAt(i) == pattern.charAt(j)){
                i++;
                j++;
                if(j == m){
                    ans.add(i-j+1);
                    j = LPS[j-1];
                }
            } else {
                if(j > 0) j = LPS[j-1];
                else i++;
            }
        }
        return ans;
    }

### Edge Cases
- NA

### Other Techniques
- NA

### Complexity
1. Time Complexity - O(N*M), where N is length of one string and M is the length of prefix
2. Space Complexity - O(M)