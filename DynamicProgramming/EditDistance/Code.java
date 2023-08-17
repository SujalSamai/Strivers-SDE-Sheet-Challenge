package DynamicProgramming.EditDistance;

import java.util.Arrays;

public class Code {
    //Memoization
    public static int minDistance(String word1, String word2){
        int n=word1.length(), m=word2.length();
        int[][] dp= new int[n][m];
        for (int[] row: dp) Arrays.fill(row, -1);
        return getMinDistance(word1, word2, n-1, m-1, dp);
    }

    private static int getMinDistance(String word1, String word2, int i, int j, int[][] dp) {
        if (i<0) return j+1;
        if (j<0) return i+1;
        if (dp[i][j]!=-1) return dp[i][j];

        if (word1.charAt(i)==word2.charAt(j)){
            return dp[i][j]= 0 + getMinDistance(word1, word2, i-1, j-1, dp);
        }
        else{
            int minInsertionDeletion = Math.min(getMinDistance(word1, word2, i-1, j, dp), getMinDistance(word1, word2, i, j-1, dp));
            return dp[i][j]= 1+ Math.min(getMinDistance(word1, word2, i-1, j-1, dp), minInsertionDeletion);
        }
    }

    //Tabulation
    public static int minDistanceTabulation(String word1, String word2){
        int n=word1.length(), m=word2.length();
        int[][] dp= new int[n+1][m+1];
        for (int i = 0; i <= n; i++) {
            dp[i][0]= i;
        }
        for (int i = 0; i <= m; i++) {
            dp[0][i]=i;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[i][j]= 0 + dp[i-1][j-1];
                }else{
                    dp[i][j] = 1 + Math.min(dp[i-1][j-1], Math.min(dp[i][j-1], dp[i-1][j]));
                }
            }
        }
        return dp[n][m];
    }
}
