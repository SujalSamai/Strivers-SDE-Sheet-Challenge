### Question
- Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer (similar to C/C++'s atoi function). 
- The algorithm for myAtoi(string s) is as follows:
  - Read in and ignore any leading whitespace. 
  - Check if the next character (if not already at the end of the string) is '-' or '+'. Read this character in if it is either. This determines if the final result is negative or positive respectively. Assume the result is positive if neither is present. 
  - Read in next the characters until the next non-digit character or the end of the input is reached. The rest of the string is ignored. 
  - Convert these digits into an integer (i.e. "123" -> 123, "0032" -> 32). If no digits were read, then the integer is 0. Change the sign as necessary (from step 2). 
  - If the integer is out of the 32-bit signed integer range [-231, 231 - 1], then clamp the integer so that it remains in the range. Specifically, integers less than -231 should be clamped to -231, and integers greater than 231 - 1 should be clamped to 231 - 1. 
  - Return the integer as the final result.

### Sample Input
    s = "   -42"
    s = "4193 with words"

### Sample Output
    -42
    4193

### Solution
- We will first of all ignore all the leading white spaces
- Once we ignore them, we reached the first char, check if it is + or - and store them in variable accordingly
- if + or - is present then do i++, else nothing is given, direct digits
- now if the character is something in range 0-9, add it in num
- if initially '-' was present then do -num
- Now check for bounds of 32 bit

### Code
    public static String longestPalindrome(String s){
        int n=s.length();
        if (n==0) return 0;
        double num=0;
        int i=0;
        while (i<n && s.charAt(i)==' ') i++;
        if (i==n) return 0;   //if all characters are whitespace

        boolean positive = s.charAt(i)=='+';
        boolean negative = s.charAt(i)=='-';
        if (positive || negative) i++;

        while (i<n && s.charAt(i) >='0' && s.charAt(i)<='9'){
            num = num*10 + (s.charAt(i)-'0');
            i++;
        }

        num= negative? -num:num;
        num = (num > Integer.MAX_VALUE) ? Integer.MAX_VALUE : num;
        num = (num < Integer.MIN_VALUE) ? Integer.MIN_VALUE : num;
        return (int) num;
    }

### Edge Cases
- NA

### Other Techniques
- NA

### Complexity
1. Time Complexity - O(N)
2. Space Complexity - O(1)