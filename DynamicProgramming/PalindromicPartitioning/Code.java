package DynamicProgramming.PalindromicPartitioning;

import java.util.Arrays;

public class Code {
    static int palindromicPartition(String str) {
        int n= str.length();
        int[][] dp= new int[n][n];
        for (int[] row: dp) Arrays.fill(row, -1);
        return getPartitions(str, 0, n-1, dp);
    }

    private static int getPartitions(String str, int s, int e, int[][] dp) {
        if (s>=e) return 0;
        if (isPalindrome(str, s, e)) return 0;
        int min= Integer.MAX_VALUE;
        if (dp[s][e]!=-1) return dp[s][e];

        int first=0, second=0;
        for (int i = s; i < e; i++) {
            if (dp[s][i]!=-1){
                first = dp[s][i];
            }else{
                first = getPartitions(str, s, i, dp);
                dp[s][i]= first;
            }

            if (dp[i+1][e]!=-1){
                second = dp[i+1][e];
            }else{
                second= getPartitions(str, i+1, e, dp);
                dp[i+1][e]= second;
            }
            int total = first+second+1;
            min= Math.min(min, total);
        }
        dp[s][e]=min;
        return min;
    }

    private static boolean isPalindrome(String str, int s, int e) {
        while (s<e){
            if (str.charAt(s)!=str.charAt(e)){
                return false;
            }
            s++;
            e--;
        }
        return true;
    }
}
