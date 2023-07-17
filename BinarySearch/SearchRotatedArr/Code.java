package BinarySearch.SearchRotatedArr;

public class Code {
    public static int search(int[] nums, int target){
        int n= nums.length;
        int low=0, high=n-1;
        while (low<=high){
            int mid= (low+high)/2;
            if (nums[mid]==target){
                return mid;
            }

            //left part is sorted
            if (nums[low]<= nums[mid]){
                //number is in the left side only
                if (nums[low]<= target && target<=nums[mid]){
                    high=mid-1;
                }else{
                    //number is in the right side
                    low= mid+1;
                }
            }
            //right part is sorted
            else{
                //number is in the right side only
                if (nums[mid]<=target && target<= nums[high]){
                    low= mid+1;
                }else{
                    //number is in the left side
                    high=mid-1;
                }
            }
        }
        return -1;
    }
}
