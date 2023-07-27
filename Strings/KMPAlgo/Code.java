package Strings.KMPAlgo;

import java.util.ArrayList;
import java.util.List;

public class Code {
    public static List< Integer > stringMatch(String text, String pattern) {
        int n = text.length(), m = pattern.length();
        List<Integer>ans=new ArrayList<>();
        int[] LPS=new int[m];
        int len = 0;
        for(int i = 1; i < m; i++){
            if(pattern.charAt(i) == pattern.charAt(len)){
                len++;
                LPS[i] = len;
            } else{
                if(len != 0){
                    len = LPS[len-1];
                }
            }
        }
        int i = 0, j = 0;
        while(i < n){
            if(text.charAt(i) == pattern.charAt(j)){
                i++;
                j++;
                if(j == m){
                    ans.add(i-j+1);
                    j = LPS[j-1];
                }
            } else {
                if(j > 0) j = LPS[j-1];
                else i++;
            }
        }
        return ans;
    }
}
