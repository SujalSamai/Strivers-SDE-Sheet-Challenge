package Arrays.ReversePairs;

import java.util.ArrayList;

public class Code {
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length-1);
    }

    private int mergeSort(int[] nums, int low, int high) {
        int count=0;
        if (low>=high) return count;
        int mid= (low+high)/2;
        count += mergeSort(nums, low, mid);
        count += mergeSort(nums, mid+1, high);
        count += merge(nums, low, mid, high);
        return count;
    }

    private int merge(int[] nums, int low, int mid, int high) {
        int count=0;
        int j= mid+1;
        for (int i = low; i <= mid ; i++) {
            while (j<=high && nums[i]> 2*(long)nums[j]){
                j++;
            }
            count += j - (mid+1);
        }

        ArrayList<Integer> temp=new ArrayList<>();
        int left=low, right=mid+1;
        while (left<=mid && right<=high){
            if (nums[left]<nums[right]){
                temp.add(nums[left]);
                left++;
            }else{
                temp.add(nums[right]);
                right++;
            }
        }
        while (left<=mid){
            temp.add(nums[left]);
            left++;
        }
        while (right<=high){
            temp.add(nums[right]);
            right++;
        }

        for (int i = low; i <= high; i++) {
            nums[i]= temp.get(i-low);
        }
        return count;
    }

}
