package DynamicProgramming.LongestIncreasingSubseq;

import java.util.Arrays;

public class Code {
    public int lengthOfLIS(int[] nums){
        int n= nums.length;
        int[][] dp = new int[n][n+1];
        for (int[] row: dp) Arrays.fill(row, -1);
        return countLIS(nums, n, 0, -1, dp);
    }

    private int countLIS(int[] nums, int n, int ind, int prevInd, int[][] dp) {
        if (ind==n){
            return 0;
        }

        if (dp[ind][prevInd+1]!=-1) return dp[ind][prevInd+1];

        int notTake = 0 + countLIS(nums, n, ind+1,prevInd, dp);
        int take = 0;
        if (prevInd==-1 || nums[ind] > nums[prevInd]){
            take = 1 + countLIS(nums, n, ind+1, ind, dp);
        }
        return dp[ind][prevInd+1] = Math.max(notTake, take);
    }
}
