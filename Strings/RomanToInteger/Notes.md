### Question
- Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

  ```Symbol       Value
  I             1
  V             5
  X             10
  L             50
  C             100
  D             500
  M             1000
  ```
- Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
  - I can be placed before V (5) and X (10) to make 4 and 9. 
  - X can be placed before L (50) and C (100) to make 40 and 90. 
  - C can be placed before D (500) and M (1000) to make 400 and 900.
- Given a roman numeral, convert it to an integer.

### Sample Input
    s = "LVIII"
    s = "MCMXCIV"

### Sample Output
    58
    1994

### Solution
- The function getIntValue() is like a switch statement which returns value corresponding to each letter
- We will start from back side, we will initialise our answer with last char's value, then we will traverse from last second char to first in backward direction
- if value of current char < value of current char + 1, then we need to subtract the value of current Char from our res. (for eg-> curChar=I, curChar+1= V -> 5-1=4)
- else we will simply add the value of curChar in our result

### Code
    public static int romanToInt(String s){
        int res= getIntValue(s.charAt(s.length()-1));
        for (int i = s.length()-2; i >=0 ; i--) {
            if (getIntValue(s.charAt(i)) < getIntValue(s.charAt(i+1))){
                res -= getIntValue(s.charAt(i));
            }else{
                res += getIntValue(s.charAt(i));
            }
        }
        return res;
    }

    public static int getIntValue(char romanChar){
        if(romanChar == 'I')
            return 1;
        else if(romanChar == 'V')
            return 5;
        else if(romanChar == 'X')
            return 10;
        else if(romanChar == 'L')
            return 50;
        else if(romanChar == 'C')
            return 100;
        else if(romanChar == 'D')
            return 500;
        else
            return 1000;
    }

### Edge Cases
- NA

### Other Techniques
- NA

### Complexity
1. Time Complexity - O(N)
2. Space Complexity - O(1)