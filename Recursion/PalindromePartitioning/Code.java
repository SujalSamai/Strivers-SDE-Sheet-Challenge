package Recursion.PalindromePartitioning;

import java.util.ArrayList;
import java.util.List;

public class Code {
    public static List<List<String>> partition (String s){
        List<List<String>> res=new ArrayList<>();
        List<String > path=new ArrayList<>();
        partitionFunc(0,s,path,res);
        return res;
    }

    private static void partitionFunc(int ind, String s, List<String> path, List<List<String>> res) {
        if(ind==s.length()){
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = ind; i < s.length(); i++) {
            if (isPalindrome(s,ind,i)){
                path.add(s.substring(ind, i+1));
                partitionFunc(i+1, s, path, res);
                path.remove(path.size()-1);
            }
        }
    }

    private static boolean isPalindrome(String s, int start, int end) {
        while (start<=end){
            if (s.charAt(start)!=s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
