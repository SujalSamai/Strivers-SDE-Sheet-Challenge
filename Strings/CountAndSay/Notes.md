### Question
- The count-and-say sequence is a sequence of digit strings defined by the recursive formula:
```countAndSay(1) = "1"```
- countAndSay(n) is the way you would "say" the digit string from countAndSay(n-1), which is then converted into a different digit string. 
- To determine how you "say" a digit string, split it into the minimal number of substrings such that each substring contains exactly one unique digit. Then for each substring, say the number of digits, then say the digit. Finally, concatenate every said digit.

```Note: Understanding the question is very important here.```

### Sample Input
    n=1
    n=4

### Sample Output
    "1"
    "1211"

### Understanding the Question
- Suppose our n=4 & we have a base case of n=1 -> "1"
- To find for 4, we need 3, to find 3 we need 2 and to get 2 we need 1 which gives "1", we will do this using recursion
- Once we reach n=1 -> it will return "1", now n=2, will read this as "one 1" or "11"
- at n=3 -> it will read the previous ans "11" as "two 1" or "21"
- at n=4 -> it will read the previous ans "21" as "one 2 one 1" or "1211"

### Solution
- We will have a base case of n=1 -> return "1"
- Through recursion we will calculate the value of previous numbers which will be a string
- For each previous number, we will traverse the current string and count the occurrences of same characters
- As soon as we encounter different characters in string, we append both count and character to our res. and then make count=0 again for next character

### Code
    public static String countAndSay(int n){
        if (n==1) return "1";
        String s= countAndSay(n-1);
        StringBuilder res= new StringBuilder();
        int count=0;

        for (int i = 0; i < s.length(); i++) {
            count++;
            if (i==s.length()-1 || s.charAt(i)!=s.charAt(i+1)){
                res.append(count).append(s.charAt(i));
                count=0;
            }
        }
        return res.toString();
    }

### Edge Cases
- NA

### Other Techniques
- NA

### Complexity
1. Time Complexity - O(N^2)
2. Space Complexity - O(N)