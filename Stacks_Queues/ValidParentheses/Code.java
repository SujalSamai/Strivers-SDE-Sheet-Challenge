package Stacks_Queues.ValidParentheses;

import java.util.Stack;

public class Code {
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
}
