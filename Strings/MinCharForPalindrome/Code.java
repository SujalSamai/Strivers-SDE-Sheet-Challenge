package Strings.MinCharForPalindrome;

public class Code {
    public static void main(String[] args) {
        String str="wererw";
        System.out.println(minCharsforPalindrome(str));
    }
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
}
