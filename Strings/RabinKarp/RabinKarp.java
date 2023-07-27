package Strings.RabinKarp;

import java.util.ArrayList;
import java.util.List;

public class RabinKarp {
    public static void main(String[] args) {
        String text="cxyzghxyzvjkxyz";
        String pattern="xyz";
        System.out.println(stringMatch(text,pattern));
    }
    public static List<Integer> stringMatch(String text, String pattern){
        int M = pattern.length();
        int N = text.length();
        int q=101, d=256;
        int i, j;
        int p = 0; // hash value for pattern
        int t = 0; // hash value for txt
        int h = 1;
        List<Integer> res= new ArrayList<>();

        // The value of h would be "pow(d, M-1)%q"
        for (i = 0; i < M - 1; i++)
            h = (h * d) % q;

        // Calculate the hash value of pattern and first window of text
        for (i = 0; i < M; i++) {
            p = (d * p + pattern.charAt(i)) % q;
            t = (d * t + text.charAt(i)) % q;
        }

        // Slide the pattern over text one by one
        for (i = 0; i <= N - M; i++) {
            // Check the hash values of current window of text and pattern.
            // If the hash values match then only check for characters one by one
            if (p == t) {
                for (j = 0; j < M; j++) {
                    if (text.charAt(i + j) != pattern.charAt(j)) break;
                }
                // if p == t and pat[0...M-1] = txt[i, i+1, ...i+M-1]
                if (j == M) res.add(i+1);
            }

            // Calculate hash value for next window of text:
            if (i < N - M) {
                // Remove leading digit, add trailing digit
                t = (d * (t - text.charAt(i) * h) + text.charAt(i + M)) % q;
                // We might get negative value of t, converting it to positive
                if (t < 0) t = (t + q);
            }
        }
        return res;
    }
}
