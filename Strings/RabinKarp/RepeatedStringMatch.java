package Strings.RabinKarp;

public class RepeatedStringMatch {
    public static int repeatedStringMatch(String a, String b){
        if (a.equals(b)) return 1;
        int c=1;
        StringBuilder dummy= new StringBuilder(new String(a));
        while(dummy.length()<b.length()) {
            c++;
            dummy.append(a);
        }

        if (dummy.toString().equals(b)) {
            return c;
        }
        if (rabinKarp(b, dummy.toString())) {
            return c;
        }
        if (rabinKarp(b,dummy+a)) {
            return c+1;
        }
        return -1;
    }

    public static boolean rabinKarp(String pattern,String text) {
        int hashcode=0;
        int currhash=0;
        for (int i = 0; i < pattern.length(); i++) {
            hashcode=hashcode+(int)pattern.charAt(i);
            currhash=currhash+(int)text.charAt(i);
        }

        for (int i = pattern.length(); i <text.length() ; i++) {
            if (hashcode==currhash) {
                if ((pattern.equals(text.substring(i-pattern.length(),i)))) {
                    return true;
                }
            }
            currhash=currhash-(int)text.charAt(i-pattern.length());
            currhash=currhash+(int)text.charAt(i);
        }

        if (hashcode==currhash) {
            return pattern.equals(text.substring(text.length() - pattern.length()));
        }

        return false;
    }
}
