### Question
- Given a string STR of length n. The task is to return the count of minimum characters to be added at front to make a string palindrome

### Sample Input
    abcd
    dad

### Sample Output
    3
    0

### Solution
- We will have two pointers one to 0 index and other to last index
- if both character are same increment i & decrement j
- else, add 1 to res, shift i back to 0, decrement trim & make j=trim

### Code
    public static int minCharsforPalindrome(String str) {
        int i=0,j=str.length()-1,trim=str.length()-1,res=0;

        while(i<j){
            if(str.charAt(i)==str.charAt(j)){
                i++;
                j--;
            }else{
                res++;
                i=0;
                trim--;
                j=trim;
            }
        }
        return res;
    }

### Edge Cases
- NA

### Other Techniques
- LPS
- nested loops

### Complexity
1. Time Complexity - O(N)
2. Space Complexity - O(1)