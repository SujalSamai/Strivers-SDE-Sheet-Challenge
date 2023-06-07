package MaximumSubarraySum;

public class Code {
//    TC- O(n) Sc-O(1)
    public static long maxSubarraySum(int[] arr, int n) {
        long maxSum= arr[0], curSum=0;
        for(int i=0; i<n; i++){
            curSum+=arr[i];
            if(maxSum< curSum){
                maxSum= curSum;
            }
            if(curSum<=0){
                curSum=0;
            }
        }
        if(maxSum<=0) return 0;
        return maxSum;
    }
}
