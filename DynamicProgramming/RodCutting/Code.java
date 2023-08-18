package DynamicProgramming.RodCutting;

import java.util.Arrays;

public class Code {
    public static int cutRod(int price[], int n) {
        int[][] dp = new int[n][n+1];
        for (int[]row : dp) Arrays.fill(row,-1);
        return cutRodHelper(price, n-1, n, dp);
    }

    private static int cutRodHelper(int[] price, int ind, int n, int[][] dp) {
        if (ind==0) return n*price[0];
        if (dp[ind][n]!=-1) return dp[ind][n];

        int notTake = 0 + cutRodHelper(price, ind-1, n, dp);
        int take = Integer.MIN_VALUE;
        int rodLen = ind+1;
        if (rodLen <= n){
            take = price[ind] + cutRodHelper(price, ind, n-rodLen, dp);
        }
        return dp[ind][n] = Math.max(notTake, take);
    }

    //Tabulation
    public static int curRodTabulation(int[] price, int n){
        int[][] dp= new int[n][n+1];
        for (int[]row: dp) Arrays.fill(row, -1);
        for (int i = 0; i <=n; i++) {
            dp[0][i] = i*price[0];
        }

        for (int ind=1; ind<n; ind++){
            for (int len = 0; len <= n; len++) {
                int notTake = 0 + dp[ind-1][len];
                int take= Integer.MIN_VALUE;
                int rodLen = ind+1;
                if (rodLen <= len){
                    take= price[ind] + dp[ind][len-rodLen];
                }
                dp[ind][len] = Math.max(take, notTake);
            }
        }
        return dp[n-1][n];
    }
}
