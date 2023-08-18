package DynamicProgramming.SubsetSumEqualK;

public class Code {
    //Memoization
    public static boolean subsetSumToK(int n, int k, int[] arr){
        boolean[][] dp= new boolean[n][k+1];
        return subsetExists(n-1, k, arr, dp);
    }

    private static boolean subsetExists(int ind, int target, int[] arr, boolean[][] dp) {
        if (target==0) return true;
        if (ind==0) return arr[0]==target;
        if (dp[ind][target]) return dp[ind][target];

        boolean notTake = subsetExists(ind-1, target, arr, dp);
        boolean take =false;
        if (arr[ind]<=target){
            take = subsetExists(ind-1, target-arr[ind], arr, dp);
        }
        dp[ind][target] = notTake || take;
        return notTake || take;
    }

    //Tabulation
    public static boolean subsetSumToKTabulation(int n, int k, int[] arr){
        boolean[][] dp= new boolean[n][k+1];
        for (int i = 0; i < n; i++)  dp[i][0]=true;
        if (arr[0]<=k) dp[0][arr[0]]=true;

        for (int ind=1; ind<n; ind++){
            for (int target = 1; target <= k; target++) {
                boolean notTake = dp[ind-1][target];
                boolean take = false;
                if (arr[ind]<=target){
                    take= dp[ind-1][target-arr[ind]];
                }
                dp[ind][target]= notTake || take;
            }
        }
        return dp[n-1][k];
    }
}
