### Question
- There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time. 
- Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.

### Sample Input
    m=3 n=7
    m=3 n=2

### Sample Output
    28
    3

### Solution
- We have to find all possible solutions, so recursion comes instantly in mind
- We can find all the possibilities of what happens if we go right & down and add them
- To reduce time complexity, we can use DP & use already counted values from the 2D DP

### Code
    public static int uniquePaths(int m, int n){
        int[][] dp=new int[m][n];
        return countPaths(0,0,m,n,dp);
    }

    private static int countPaths(int i, int j, int m, int n, int[][] dp) {
        if(i==(m-1)&&j==(n-1)) return 1;
        if(i>=m||j>=n) return 0;

        if(dp[i][j]!=0) return dp[i][j];
        else return dp[i][j]=countPaths(i+1,j,m,n, dp) + countPaths(i, j+1, m, n, dp);
    }

### Edge Cases
- If m & n =1 then there is only one path, return 1
- if we go outside, row or column range, return 0

### Other Techniques
- Recursion
- Combinatorics

### Complexity
1. Time Complexity - O(M*N)
2. Space Complexity - O(M*N)