package Strings.CountAndSay;

public class Code {
    public static void main(String[] args) {
        int n=4;
        System.out.println(countAndSay(n));
    }
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
}
