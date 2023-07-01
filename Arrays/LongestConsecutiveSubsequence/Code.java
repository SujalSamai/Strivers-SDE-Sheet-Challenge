package Arrays.LongestConsecutiveSubsequence;

import java.util.Arrays;
import java.util.HashSet;

public class Code {

    //sorting - O(NlogN)
    public static int longestConsecutive(int[] nums){
        if(nums.length == 0 || nums == null){
            return 0;
        }
        Arrays.sort(nums);
        int maxStreak=1;
        int curStreak=1;
        for (int i=1; i<nums.length; i++) {
            if(nums[i]==nums[i-1]+1){
                curStreak++;
            }else if(nums[i]!=nums[i-1]){
                curStreak=1;
            }
            maxStreak= Math.max(maxStreak, curStreak);
        }
        return maxStreak;
    }

    //Hashset - O(N) & O(N)
    public static int longestConsecutiveOptimal(int[] nums){
        HashSet<Integer> set=new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int maxStreak=0;
        for (int num : nums) {
            //making sure that the number we are choosing is the first number for the sequence
            if (!set.contains(num-1)){
                int curNum=num;
                int curStreak=1;
                while (set.contains(curNum+1)){
                    curStreak++;
                    curNum++;
                }
                maxStreak= Math.max(maxStreak,curStreak);
            }
        }
        return maxStreak;
    }
}
