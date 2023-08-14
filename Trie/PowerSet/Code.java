package Trie.PowerSet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Code {
    public List<String> AllPossibleStrings(String s) {
        List<String> ans= new ArrayList<>();
        String cur="";
        int i=0;
        powerSet(s, i, cur, ans);
        Collections.sort(ans);
        return ans;
    }

    private void powerSet(String s, int i, String cur, List<String> ans) {
        if (i==s.length()){
            if (!cur.isEmpty()){
                ans.add(cur);
            }
            return;
        }

        powerSet(s, i+1, cur+s.charAt(i), ans);
        powerSet(s, i+1, cur, ans);
    }
}
