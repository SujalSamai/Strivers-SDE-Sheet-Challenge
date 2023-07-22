### Question
- Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid. 
- An input string is valid if:
  - Open brackets must be closed by the same type of brackets. 
  - Open brackets must be closed in the correct order. 
  - Every close bracket has a corresponding open bracket of the same type.

### Sample Input
    s = "()[]{}"
    s = "(]"

### Sample Output
    true
    false

### Solution
- traverse each character of string
- if char is opening bracket, push into stack
- each time we will see a closing bracket char and our stack top contain its equivalent opening bracket, we will continue, else we return false

### Code
    public static boolean isValid(String s){
        Stack<Character> st= new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)=='(' || s.charAt(i)=='{' || s.charAt(i)=='['){
                st.push(s.charAt(i));
            }else{
                if (st.isEmpty()) return false;
                else{
                    char c= st.pop();
                    if ((s.charAt(i)==')' && c=='(') || (s.charAt(i)=='}' && c=='{') || (s.charAt(i)==']' && c=='[')){
                        continue;
                    }else{
                        return false;
                    }
                }
            }
        }
        return st.isEmpty();
    }

### Edge Cases
- NA

### Other Techniques
- NA

### Complexity
1. Time Complexity - O(N)
2. Space Complexity - O(N)