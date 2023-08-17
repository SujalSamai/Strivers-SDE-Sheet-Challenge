package DynamicProgramming.MatrixChainMultiplication;

import java.util.Arrays;

public class Code {
    static int matrixMultiplication(int N, int[] arr) {
        int[][] dp= new int[N][N];
        for (int[] row: dp) Arrays.fill(row, -1);

        return getMCM(arr, 1, N-1, dp);
    }

    private static int getMCM(int[] arr, int i, int j, int[][] dp) {
        if (i==j) return 0;
        if (dp[i][j] != -1) return dp[i][j];
        int mini = Integer.MAX_VALUE;

        for (int k =i; k<=j-1; k++){
            int ans = getMCM(arr, i, k, dp) + getMCM(arr, k+1, j, dp) + arr[i-1] * arr[k] * arr[j];
            mini = Math.min(mini, ans);
        }
        dp[i][j]= mini;
        return mini;
    }
}
