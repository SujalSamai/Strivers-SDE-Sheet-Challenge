package DynamicProgramming.MaxSumIncreasingSubseq;

import java.util.Arrays;

public class Code {
    //Memoization
    public int maxSumIS(int arr[], int n) {
        int[][] dp = new int[n][n+1];
        for (int[] row: dp) Arrays.fill(row, -1);
        return getMaxSum(arr, n, 0, -1, dp);
    }

    private int getMaxSum(int[] arr, int n, int ind, int prev, int[][] dp) {
        if (ind==n) return 0;
        if (dp[ind][prev+1]!=-1) return dp[ind][prev+1];

        int notTake = 0 + getMaxSum(arr, n, ind+1, prev, dp);
        int take = 0;
        if (prev==-1 || arr[ind] > arr[prev]){
            take = arr[ind] + getMaxSum(arr, n, ind+1, ind, dp);
        }

        return dp[ind][prev+1] = Math.max(take, notTake);
    }

    //Tabulation
    public static int maxSumISTabulation(int[] arr, int n){
        int[][] dp= new int[n+1][n+1];
        for (int ind=n-1; ind>=0; ind--){
            for (int prev = ind-1; prev >= -1 ; prev--) {
                int take =0;
                if (prev==-1 || arr[ind]>arr[prev]){
                    take = arr[ind] + dp[ind+1][ind+1];
                }
                int notTake = 0 + dp[ind+1][prev+1];
                dp[ind][prev+1] = Math.max(take, notTake);
            }
        }
        return dp[0][0];
    }
}
