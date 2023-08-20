package DynamicProgramming.EggDropping;

import java.util.Arrays;

public class Code {
    static int eggDrop(int n, int k) {
        int[][] dp = new int[n+1][k+1];
        for (int[] row:dp) Arrays.fill(row, -1);
        return helper(n, k, dp);
    }

    private static int helper(int n, int k, int[][] dp) {
        if (k==0 || k==1) return k;
        if (n==1) return k;

        if (dp[n][k] != -1) return dp[n][k];
        int mini=Integer.MAX_VALUE;
        int s1, s2;
        for (int i = 1; i <= k; i++) {
            if (dp[n-1][i-1] != -1){
                s1 = dp[n-1][i-1];
            }else{
                s1 = helper(n-1, i-1, dp);
            }

            if (dp[n][k-i] != -1){
                s2 = dp[n][k-i];
            }else{
                s2 = helper(n, k-i, dp);
            }

            int temp= 1 + Math.max(s1, s2);
            mini = Math.min(mini, temp);
        }
        return dp[n][k] = mini;
    }
}
