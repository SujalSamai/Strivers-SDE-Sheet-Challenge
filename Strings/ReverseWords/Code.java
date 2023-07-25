package Strings.ReverseWords;

public class Code {
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
}
