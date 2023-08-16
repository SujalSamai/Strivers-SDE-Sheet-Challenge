package DynamicProgramming.Knapsack01;

import java.util.Arrays;

public class Code {
    //Memoization
    static int knapSackMemo(int W, int[] wt, int[] val, int n) {
        int[][] dp = new int[n][W+1];
        for (int[] row: dp) Arrays.fill(row, -1);
        return knapSackUtil(W, wt, val, n-1, dp);
    }

    private static int knapSackUtil(int W, int[] wt, int[] val, int ind, int[][] dp) {
        if (ind==0){
            if (wt[0] <= W) return val[0];
            else return 0;
        }

        if (dp[ind][W]!= -1) return dp[ind][W];
        int notTaken = 0 + knapSackUtil(W, wt, val, ind-1, dp);
        int taken = Integer.MIN_VALUE;
        if (wt[ind]<=W){
            taken = val[ind] + knapSackUtil(W-wt[ind], wt, val, ind-1, dp);
        }

        return dp[ind][W] = Math.max(taken, notTaken);
    }


    //Tabulation
    static int knapSack(int W, int[] wt, int[] val, int n){
        int dp[][] = new int[n][W+1];
        for(int i=wt[0]; i<=W; i++){
            dp[0][i] = val[0];
        }

        for(int ind =1; ind<n; ind++){
            for(int cap=0; cap<=W; cap++){
                int notTaken = 0 + dp[ind-1][cap];
                int taken = Integer.MIN_VALUE;
                if(wt[ind] <= cap)
                    taken = val[ind] + dp[ind-1][cap - wt[ind]];
                dp[ind][cap] = Math.max(notTaken, taken);
            }
        }

        return dp[n-1][W];
    }
}
