package LongestSubstringWithoutRepeat;

import java.util.HashSet;

public class Code {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0) return 0;
        HashSet<Character> set= new HashSet<>();
        int left=0;
        int maxAns= Integer.MIN_VALUE;
        for (int right=0; right<s.length(); right++){
            if(set.contains(s.charAt(right))){
                while (left<right && set.contains(s.charAt(right))){
                    set.remove(s.charAt(left));
                    left++;
                }
            }
            set.add(s.charAt(right));
            maxAns= Math.max(maxAns, right-left+1);
        }
        return maxAns;
    }
}
