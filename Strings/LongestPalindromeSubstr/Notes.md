### Question
- Given a string s, return the longest palindromic substring in s.

### Sample Input
    s = "babad"
    s = "cbbd"

### Sample Output
    "bab" or "aba"
    "bb"

### Solution
- A way to check if a substring is palindrome or not is, suppose we are at character 'a' in the string 'babxd', then we know, we can check to left side and right side one by one character, if char to left & right are same then we keep on updating length of palindrome until we are out of bound or left and right char are not same
- we do the same thing here, for each character we travel to left and right side and keep on updating the resLength to keep it maximum (to get length of palindrome do r-l+1)
- But, this is right for palindromes having odd length, for palindromes having even length we need to initialise l=i, r=i+1

### Code
    public static String longestPalindrome(String s){
        int n=s.length();
        if (n<2) return s;
        int resLen=0;
        StringBuilder res= new StringBuilder();

        for (int i=0; i<n; i++){
            //for odd length
            int l=i, r=i;
            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                if ((r-l+1) > resLen){
                    res= new StringBuilder(s.substring(l, r + 1));
                    resLen=r-l+1;
                }
                l--;
                r++;
            }

            //even length
            l=i;
            r=i+1;
            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                if ((r-l+1) > resLen){
                    res= new StringBuilder(s.substring(l, r + 1));
                    resLen=r-l+1;
                }
                l--;
                r++;
            }
        }
        return res.toString();
    }

### Edge Cases
- NA

### Other Techniques
- DP

### Complexity
1. Time Complexity - O(N^2)
2. Space Complexity - O(1)