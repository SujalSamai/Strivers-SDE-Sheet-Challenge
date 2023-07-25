package Strings.LongestPalindromeSubstr;

public class Code {
    public static void main(String[] args) {
        String s="babad";
        System.out.println(longestPalindrome(s));
    }
    public static String longestPalindrome(String s) {
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
}
