### Question
- Consider a rat placed at (0, 0) in a square matrix of order N * N. It has to reach the destination at (N - 1, N - 1). 
- Find all possible paths that the rat can take to reach from source to destination. The directions in which the rat can move are 'U'(up), 'D'(down), 'L' (left), 'R' (right).
- Value 0 at a cell in the matrix represents that it is blocked and rat cannot move to it while value 1 at a cell in the matrix represents that rat can be travel through it. 
- Note: In a path, no cell can be visited more than one time. If the source cell is 0, the rat cannot move to any other cell.

### Sample Input
    N = 4
    m[][] = {{1, 0, 0, 0},
            {1, 1, 0, 1},
            {1, 1, 0, 0},
            {0, 1, 1, 1}}
    
    N = 2
    m[][] = {{1, 0},
            {1, 0}}

### Sample Output
    DDRDRR DRDDRR
    -1

### Solution
- As we need to return the answers in lexicographical order, we will generate answer by checking down, left, right, and up fashion
- we will create a visited array to mark the cell we have already visited as we can't go to a cell which is already visited
- we will check conditions for down, left, right, up one by one, and if condition is satisfied we will mark the index in visited array
- and move to our next cell recursively, if the current recursion didn't bring any result we will backtrack and unmark our visited array

### Code
    public static ArrayList<String> findPath(int[][] m, int n) {
        int[][] vis= new int[n][n];
        ArrayList<String> ans= new ArrayList<>();
        if (m[0][0]==1) solve(0,0,m,n,ans,"",vis);
        return ans;
    }

    private static void solve(int i, int j, int[][] m, int n, ArrayList<String> ans, String s, int[][] vis) {
        if (i==n-1 && j==n-1){
            ans.add(s);
            return;
        }

        //downward
        if (i+1<n && vis[i+1][j]==0 && m[i+1][j]==1){
            vis[i][j]=1;
            solve(i+1, j, m, n, ans, s+'D', vis);
            vis[i][j]=0;
        }

        //left
        if (j-1>=0 && vis[i][j-1]==0 && m[i][j-1]==1){
            vis[i][j]=1;
            solve(i, j-1, m, n, ans, s+'L', vis);
            vis[i][j]=0;
        }

        //right
        if (j+1<n && vis[i][j+1]==0 && m[i][j+1]==1){
            vis[i][j]=1;
            solve(i, j+1, m, n, ans, s+'R', vis);
            vis[i][j]=0;
        }

        //up
        if (i-1>=0 && vis[i-1][j]==0 && m[i-1][j]==1){
            vis[i][j]=1;
            solve(i-1, j, m, n, ans, s+'U', vis);
            vis[i][j]=0;
        }
    }

### Other Techniques
- NA

### Complexity
1. Time Complexity - O(4^(m*n))
2. Space Complexity - O(m*n)