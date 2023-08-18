### Question
- You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money. 
- Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1. 
- You may assume that you have an infinite number of each kind of coin.

### Sample Input
    coins = [1,2,5], amount = 11
    coins = [2], amount = 3

### Sample Output
    3
    -1

### Solution
- Create a dp array of size [n][T+1]. The size of the input array is ‘N’, so the index will always lie between ‘0’ and ‘n-1’. The target can take any value between ‘0’ and ‘amount’. Therefore we take the dp array as dp[n][amount+1]
- Whenever we want to find the answer of particular parameters (say f(ind,target)), we first check whether the answer is already calculated using the dp array(i.e dp[ind][target]!= -1 ). If yes, simply return the value from the dp array.
- We can either take a particular denomination of coin or not take it
- Not Take: When we don't take a denomination, we will simply decrement our index & move to next denomination
- Take: If the current denomination is <= amount, then we can take the current denomination, we will add one to our answer, and decrease the amount. But we won't decrement the index as we have unlimited supply of each coin
- At last, we will return the min of taken/not taken as we need minimum number of coins to sum up to the amount
- Base case: when ind==0, only one coin denomination remaining, if adding it can lead to our amount, then we add it, else we return a very high value, so it can never come in our answer
- At the end we return the denomination, if it's a large value, that means we couldn't find it and return -1

### Code
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

### Complexity
1. Time Complexity - O(N*amount)
2. Space Complexity - O(N*amount)