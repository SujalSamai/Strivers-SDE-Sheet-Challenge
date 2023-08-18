### Question
- You are given an arr of n positive integers and an integer 'K'
- Your task is to check if there exists a subset in arr with a sum equal to k

### Sample Input
    arr = [4,3,2,1], k=5
    nums = [2,5,1,6,7], k=4

### Sample Output
    true
    false

### Solution
- Create a dp array of size [n][k+1]. The size of the input array is ‘n’, so the index will always lie between ‘0’ and ‘n-1’. The target can take any value between ‘0’ and ‘k’. Therefore we take the dp array as dp[n][k+1]
- If target == 0, it means that we have already found the subsequence from the previous steps, so we can return true. 
- If ind==0, it means we are at the first element, so we need to return arr[ind]==target. If the element is equal to the target we return true else false.
- Exclude the current element in the subsequence: We first try to find a subsequence without considering the current index element. For this, we will make a recursive call to f(ind-1,target). 
- Include the current element in the subsequence: We will try to find a subsequence by considering the current index as element as part of subsequence. As we have included arr[ind], the updated target which we need to find in the rest if the array will be target – arr[ind]. Therefore, we will call f(ind-1,target-arr[ind]).
- As we are looking for only one subset, if any of the one among taken or not taken returns true, we can return true from our function. Therefore, we return ‘or(||)’ of both of them.

### Code
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

### Other Techniques
- NA

### Complexity
1. Time Complexity - O(N*K)
2. Space Complexity - O(N*K)