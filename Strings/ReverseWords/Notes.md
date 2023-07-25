### Question
- Given an input string s, reverse the order of the words. 
- A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space. 
- Return a string of the words in reverse order concatenated by a single space. 
- Note that s may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space separating the words. Do not include any extra spaces.

### Sample Input
    s = "the sky is blue"
    s = "  hello world  "

### Sample Output
    "blue is sky the"
    "world hello"

### Solution
- Take two strings, we will be moving from back, so our string will be initially reverse
- if character is not a space add it in temp
- when we encounter a space between two words or this is the last letter of entire sentence & temp.length >0 (won't run for leading and trailing space)
  - we will add a space in our answer if ans.length>0
  - reverse temp as we were traversing from back
  - add temp to our answer
  - remove all letters from temp

### Code
    public static String reverseWords(String s){
        int n= s.length();
        StringBuilder ans= new StringBuilder();
        StringBuilder temp= new StringBuilder();

        for (int i = n-1; i >=0 ; i--) {
            char ch= s.charAt(i);
            if (ch !=' ') temp.append(ch);

            if ((ch== ' ' || i==0) && temp.length() > 0){
                if (ans.length()>0) ans.append(" ");
                temp.reverse();
                ans.append(temp);
                temp.setLength(0);
            }
        }
        return ans.toString();
    }

### Edge Cases
- NA

### Other Techniques
- Stack

### Complexity
1. Time Complexity - O(N)
2. Space Complexity - O(1)