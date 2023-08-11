### Question
- Given an m x n 2D binary grid which represents a map of '1's (land) and '0's (water), return the number of islands. 
- An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

### Sample Input
    grid = [
      ["1","1","1","1","0"],
      ["1","1","0","1","0"],
      ["1","1","0","0","0"],
      ["0","0","0","0","0"]
    ]

### Sample Output
    1

### Solution
- We will initialise a count variable & then traverse each cell of the grid
- if the cell is marked as '1', then we perform the dfs i.e., mark the current cell as '2' and check its four adjacent cells for the same
- and increment count
- We are marking '1' as '2' to make sure that this cell is already visited & we must not check & count it again
- count is incremented after dfs call as we need to increment for a whole island not for individual cell, dfs will make sure whole island is converted to '2' mark & will return if it finds water('0')

### Code
    public static int numIslands(char[][] grid){
        if (grid.length==0) return 0;
        int count=0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j]=='1'){
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private static void dfs(char[][] grid, int i, int j) {
        if (i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]!='1'){
            return;
        }
        grid[i][j]='2';
        dfs(grid, i+1, j);
        dfs(grid, i, j+1);
        dfs(grid, i-1, j);
        dfs(grid, i, j-1);
    }

### Other Techniques
- NA

### Complexity
1. Time Complexity - O(M*N)
2. Space Complexity - O(M*N)