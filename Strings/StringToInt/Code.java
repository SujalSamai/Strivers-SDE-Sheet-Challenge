package Strings.StringToInt;

public class Code {
    public static int myAToi(String s){
        int n=s.length();
        if (n==0) return 0;
        double num=0;
        int i=0;
        while (i<n && s.charAt(i)==' ') i++;
        if (i==n) return 0;

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
}
