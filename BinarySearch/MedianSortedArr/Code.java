package BinarySearch.MedianSortedArr;

public class Code {
    public double findMedianSortedArrays(int[] nums1, int[] nums2){
        if(nums2.length> nums1.length){
            return findMedianSortedArrays(nums2, nums1);    //to ensure we are always partitioning the smaller arr first
        }

        //take two pointers in the smaller arr
        int low=0, high=nums1.length;
        int mPos= ((nums1.length+nums2.length)+1)/2;    //when we find median, it is generally the mid element from entire search space
        while (low<=high){
            int cut1= (low+high)/2;     //make cut1
            int cut2= mPos-cut1;        //the number of remaining elements will be there in cut2

            int l1= (cut1==0) ? Integer.MIN_VALUE : nums1[cut1-1];  //our l1 will be the last element before cut1 is made
            int l2= (cut2==0) ? Integer.MIN_VALUE : nums2[cut2-1];  //our l2 will be the last element before cut2 is made
            int r1= (cut1==nums1.length) ? Integer.MAX_VALUE : nums1[cut1]; //r1 will be first element after cut1 is made
            int r2= (cut2==nums2.length) ? Integer.MAX_VALUE : nums2[cut2]; //r2 will be first element after cut2 is made

            if (l1<=r2 && l2<=r1){
                if ((nums1.length + nums2.length) % 2 !=0){     //if total elements are odd
                    return Math.max(l1,l2);     //return last element from left side i.e. max one
                }else{      //if total elements are even
                    return (Math.max(l1,l2) + Math.min(r1,r2))/2.0;     //max from left + min from right / 2
                }
            }
            else if (l1>r2) high=cut1-1;    //if l1 > r2, we need to reduce l1 and increase r2, so shift high
            else low=cut1+1;    //if l2 > r1, we need to increase l2 and reduce r1, so shift low
        }
        return 0.0;
    }
}
