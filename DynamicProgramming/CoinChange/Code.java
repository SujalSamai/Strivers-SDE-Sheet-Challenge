package DynamicProgramming.CoinChange;

import java.util.Arrays;

public class Code {
    public static void main(String[] args) {
        int[] coins = {2,5,10,1};
        int amount=27;
        System.out.println(coinChange(coins, amount));
    }

    //Memoization
    public static int coinChange(int[] coins, int amount){
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        for (int[] row: dp) Arrays.fill(row, -1);
        int ans = minCoins(coins, n-1, amount, dp);
        if (ans>=(int)1e9) return -1;
        else return ans;
    }

    private static int minCoins(int[] coins, int ind, int amount, int[][] dp) {
        if (ind==0){
            if (amount%coins[0]==0) return amount/coins[0];
            else return (int)1e9;
        }

        if (dp[ind][amount]!=-1) return dp[ind][amount];

        int notTaken = minCoins(coins, ind-1, amount, dp);
        int taken = (int)1e9;
        if(coins[ind]<=amount){
            taken = 1 + minCoins(coins, ind, amount-coins[ind], dp);
        }
        return dp[ind][amount]= Math.min(notTaken, taken);
    }

    //Tabulation
    public static int coinChangeTabulation(int[] coins, int amount){
        int n=coins.length;
        int[][] dp = new int[n+1][amount+1];
        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < amount+1; j++) {
                if (i==0 && j==0) dp[i][j]=0;
                else if (i==0) dp[i][j] = Integer.MAX_VALUE-1;
                else if (j==0) dp[i][j]=0;
                else{
                    if (coins[i-1] > j){
                        dp[i][j] = dp[i-1][j];
                    }else{
                        dp[i][j]= Math.min(dp[i-1][j], 1+ dp[i][j-coins[i-1]]);
                    }
                }
            }
        }
        if (dp[n][amount] > 100000 || dp[n][amount]<0) return -1;
        else return dp[n][amount];
    }
}
