package Recursion.Permutations;

import java.util.ArrayList;
import java.util.List;

public class Code {
    public static List<List<Integer>> permute(int[] nums){
        List<List<Integer>> ans=new ArrayList<>();
        recurPermutation(0,nums,ans);
        return ans;
    }

    private static void recurPermutation(int ind, int[] nums, List<List<Integer>> ans) {
        if (ind==nums.length){
            List<Integer> ds=new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                ds.add(nums[i]);
            }
            ans.add(new ArrayList<>(ds));
            return;
        }

        for (int i = ind; i < nums.length; i++) {
            swap(i, ind, nums);
            recurPermutation(ind+1, nums, ans);
            swap(i, ind, nums);
        }
    }

    private static void swap(int i, int j, int[] nums) {
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}
