package Recursion.SubsetSum;

import java.util.ArrayList;
import java.util.Collections;

public class Code {
    public static ArrayList<Integer> subsetSum(int num[]) {
        int n=num.length;
        ArrayList<Integer> sumSubset = new ArrayList<>();
        subsetSumHelper(0,0,num,n,sumSubset);
        Collections.sort(sumSubset);
        return sumSubset;
    }

    static void subsetSumHelper(int ind, int sum, int[] nums, int n, ArrayList<Integer> sumSubset){
        if(ind == n){
            sumSubset.add(sum);
            return;
        }

        //pick
        subsetSumHelper(ind+1, sum+nums[ind], nums, n, sumSubset);

        //not pick
        subsetSumHelper(ind+1, sum, nums, n, sumSubset);
    }
}
