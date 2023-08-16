### Question
- You are given weights and values of N items, put these items in a knapsack of capacity W to get the maximum total value in the knapsack. Note that we have only one quantity of each item. 
- In other words, given two integer arrays val[0..N-1] and wt[0..N-1] which represent values and weights associated with N items respectively. Also given an integer W which represents knapsack capacity, find out the maximum value subset of val[] such that sum of the weights of this subset is smaller than or equal to W. 
- You cannot break an item, either pick the complete item or dont pick it (0-1 property).

### Sample Input
    N = 3, W = 4, values[] = {1,2,3}, weight[] = {4,5,1} 
    N = 3, W = 3, values[] = {1,2,3}, weight[] = {4,5,6}

### Sample Output
    3
    0

### Solution
**Memoization:**
- We will initialize our DP[n][W+1] and fill it with -1. Since capacity can take any value from 0 to W, so we take W+1. The size of the input array is ‘N’, so the index will always lie between ‘0’ and ‘n-1’.
- We will start from the last item, and check if it is already in our dp table
- We can either take an item or not take. Not taken: we will just decrease index, without changing capacity
- for taking, current weight should be less than or equal to total capacity, while taking, we will add value[ind] to our answer & decrease the index & capacity from W to W-wt[ind]
- at the end return max of taken/not taken

**Tabulation:**
- At ind==0, we are considering the first element, if the capacity of the knapsack is greater than the weight of the first item, we return val[0] as answer. We will achieve this using a for loop. 
- Next, we are done for the first row, so our ‘ind’ variable will move from 1 to n-1, whereas our ‘cap’ variable will move from 0 to ‘W’. We will set the nested loops to traverse the dp array. 
- Inside the nested loops we will apply the recursive logic to find the answer of the cell. 
- When the nested loop execution has ended, we will return dp[n-1][W] as our answer.

### Code
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

### Other Techniques
- NA

### Complexity
1. Time Complexity - O(N*W)
2. Space Complexity - O(N*W)