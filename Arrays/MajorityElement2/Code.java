package Arrays.MajorityElement2;

import java.util.ArrayList;
import java.util.List;

public class Code {
    public static List<Integer> majorityElement(int[] nums){
        List<Integer> res=new ArrayList<>();
        if (nums.length==0) return res;
        int num1=-1, num2=-1;
        int count1=0, count2=0;

        for (int val : nums) {
            if (val==num1){
                count1++;
            }
            else if (val==num2){
                count2++;
            }
            else if(count1==0){
                num1=val;
                count1=1;
            }else if(count2==0){
                num2=val;
                count2=1;
            }else{
                count1--;
                count2--;
            }
        }
        
        count1=0;
        count2=0;
        for (int val : nums) {
            if (val==num1){
                count1++;
            }
            else if(val==num2){
                count2++;
            }
        }
        if(count1>nums.length/3){
            res.add(num1);
        }
        if (count2> nums.length/3){
            res.add(num2);
        }
        return res;
    }
}
