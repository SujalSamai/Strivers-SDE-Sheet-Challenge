package GridUniquePaths;

public class Code {
//    Recursion - Exponential TTL
//    public static int uniquePaths(int m, int n){
//        return countPaths(0,0,m,n);
//    }
//
//    private static int countPaths(int i, int j, int m, int n) {
//        if(i==m-1 && j==n-1) return 1;
//        if(i>=m || j>=n) return 0;
//        else{
//            return countPaths(i+1,j,m,n) + countPaths(i, j+1, m, n);
//        }
//    }

    //DP - O(n*m) & O(n*m)
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
}
