### Question
- Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path. 
- Note: You can only move either down or right at any point in time.

### Sample Input
    grid = [[1,3,1],[1,5,1],[4,2,1]]
    grid = [[1,2,3],[4,5,6]]

### Sample Output
    7
    12

### Solution
- We will be doing a top-down recursion, i.e we will move from the cell[M-1][N-1] and try to find our way to the cell[0][0]. Therefore at every index, we will try to move up and towards the left.
- When i=0 and j=0, that is we have reached the destination so we can add to path the current cell value, hence we return grid[0][0]. 
- When i<0 or j<0, it means that we have crossed the boundary of the matrix and we don’t want to find a path from here, so we return a very large number( say, 1e9) so that this path is rejected by the calling function.
- As we are writing a top-down recursion, at every index we have two choices, one to go up(↑) and the other to go left(←). To go upwards, we will reduce i by 1, and move towards left we will reduce j by 1. 
- Now when we get our answer for the recursive call (f(i-1,j) or f(i,j-1)), we need to also add the current cell value to it as we have to include it too for the current path sum.
- As we have to find the minimum path sum of all the possible unique paths, we will return the minimum of the choices(up and left)

### Code
    //Memoization
    public static int minPathSum(int[][] grid){
        int n= grid.length;
        int m= grid[0].length;
        int[][] dp = new int[n][m];
        for(int[]row: dp) Arrays.fill(row, -1);
        return findPath(n-1, m-1, grid, dp);
    }

    private static int findPath(int i, int j, int[][] grid, int[][] dp) {
        if (i==0 && j==0) return grid[0][0];
        if (i<0 || j<0) return (int)1e9;
        if (dp[i][j]!=-1) return dp[i][j];

        int up= grid[i][j] + findPath(i-1, j, grid, dp);
        int left= grid[i][j] + findPath(i, j-1, grid, dp);
        return dp[i][j]= Math.min(up, left);
    }

    //Tabulation
    public static int minPathSumTabulation(int[][] grid){
        int n= grid.length, m = grid[0].length;
        int[][] dp= new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i==0 && j==0) dp[i][j]= grid[i][j];
                else{
                    int up= grid[i][j];
                    if (i>0) up += dp[i-1][j];
                    else up += (int)1e9;

                    int left= grid[i][j];
                    if (j>0) left += dp[i][j-1];
                    else left += (int)1e9;

                    dp[i][j] = Math.min(up, left);
                }
            }
        }
        return dp[n-1][m-1];
    }

### Other Techniques
- NA

### Complexity
1. Time Complexity - O(N*M)
2. Space Complexity - O(N*M)