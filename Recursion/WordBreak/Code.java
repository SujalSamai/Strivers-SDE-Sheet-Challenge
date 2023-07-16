package Recursion.WordBreak;

import java.util.ArrayList;
import java.util.HashSet;

public class Code {
    public static ArrayList<String> wordBreak(String s, ArrayList<String> dictionary) {
        HashSet<String> set = new HashSet<>(dictionary);

        ArrayList<String> res= new ArrayList<>();
        solve(0, s, new ArrayList<>(), set, res);
        return res;
    }

    private static void solve(int ind, String s, ArrayList<Object> list, HashSet<String> set, ArrayList<String> res) {
        if (ind==s.length()){
            StringBuilder str= new StringBuilder();
            for (int i = 0; i < list.size(); i++) {
                str.append(list.get(i));
                str.append(" ");
            }
            res.add(str.toString());
            return;
        }

        for (int i = ind; i < s.length(); i++) {
            if (set.contains(s.substring(ind, i+1))){
                list.add(s.substring(ind, i+1));
                solve(i+1, s, list, set, res);
                list.remove(list.size()-1);
            }
        }
    }
}
