### Question
- Given a rod of length 'N' units. The rod can be cut into different sizes and each size has a cost associated with it.
- Determine the maximum cost obtained by cutting the rod and selling its pieces

### Sample Input
    price = [2,5,7,8,10]
    price = [3,5,8,9,10,17,17,20]

### Sample Output
    12
    24

### Solution
- The price of individual lengths is given by the price array. Price[0] gives us the price of a rod with length 1, index 2 gives us a rod with length 2, and so on. We can cut a rod from index 0 to  N-1. ( where the length of the rod will be ‘ind+1’). One parameter will be ‘ind’ which tells us the rod length that we want to cut from the original rod. Initially, we would want to consider the entire rod length
- We are given a rod with length ‘N’.So clearly another parameter will be ‘N’, i.e the total rod length that is given to us so that we can know the maximum length of rods that we can cut. 
- Initially, we would want to find f(N-1, N), i.e the maximum revenue generated by considering all rod lengths from index 0 to N-1 (i.e from length 1 to length N) with the total rod length given as N.
- Create a dp array of size [N][N+1]. The size of the price array is ‘N’, so the index will always lie between ‘0’ and ‘N-1’. The rod length can take any value between ‘0’ and ‘N’. Therefore we take the dp array as dp[N][N+1]
- If ind==0, it means we are considering a rod of length 1. Its price is given by price[0]. Now for length N, the number of rod pieces of length 1 will be N (N/1). Therefore we will return the maximum revenue generated,i.e ‘N*price[0]’.
- We first try to find a subsequence without considering the current index irod length. If we exclude the current item, the total length of the rod will not be affected and the revenue added will be 0 for the current item. So we will call the recursive function f(ind-1,N)
- We will try to find a subsequence by considering the current index rod length. As we have cut the rod, the total rod length will be updated to N-(ind+1), where ‘ind+1’ is the rod length, and the current rod piece price’s value (price[ind]) will also be added to the further recursive call answer.
- Now here is the catch, we can cut the rod piece of the same index length. So we will not recursively call for f(ind-1, N-(ind+1)) rather we will stay at that index only and call for f(ind, N-(ind+1)) to find the answer.
- As we have to return the maximum amount of price we can generate, we will return the maximum of take and notTake.

### Code
    //Memoization
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

### Other Techniques
- NA

### Complexity
1. Time Complexity - O(N*N)
2. Space Complexity - O(N*N)