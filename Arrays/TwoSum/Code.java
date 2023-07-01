package Arrays.TwoSum;

import java.util.Arrays;
import java.util.HashMap;

public class Code {
    public static void main(String[] args) {
        int[] arr={2,7,11,15};
        int target=9;
        System.out.println(Arrays.toString(twoSum(arr, target)));
    }
    public static int[] twoSum(int[] nums, int target){
        HashMap<Integer, Integer> map=new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])){   //checks if num[i] is already added in map
                return new int[]{map.get(nums[i]), i};
            }
            map.put(target-nums[i], i);     //keeps adding target-num[i] in the map
            //if array has element which will help in achieving the target then, target-nums[i] will definitely be present in the array
        }
        return new int[0];
    }
}
