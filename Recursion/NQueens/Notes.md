### Question
- The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other. 
- Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order. 
- Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space, respectively.

### Sample Input
    4
    1

### Sample Output
    [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
    [["Q"]]

### Solution
- Using the concept of Backtracking, we will place Queen at different positions of the chessboard and find the right arrangement where all the n queens can be placed on the n*n grid.
- A queen can attack on 8 sides, but we only need to check 3 of them (left, upperLeftDiagonal, lowerLeftDiagonal) since, we haven't added any Queen yet on rest of the sides
- Create a nXn chessboard, fill it empty. Create three hashtables to check if we can add a Queen to a particular place
- We will traverse all the rows of a column at each iteration, we will check if the left side, lowerLeftDiagonal or upperLeftDiagonal has empty places or not
- If yes, we will add a Queen and move recursively to next column since we can't add anymore Queen to this column
- If we go till end column, we get our answer, else we just backtrack
- while backtracking make sure to remove our previous marked answers

### Code
    public static List < List < String >> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                board[i][j] = '.';
        List < List < String >> res = new ArrayList < List < String >> ();
        int leftRow[] = new int[n];
        int upperDiagonal[] = new int[2 * n - 1];
        int lowerDiagonal[] = new int[2 * n - 1];
        solve(0, board, res, leftRow, lowerDiagonal, upperDiagonal);
        return res;
    }

    static void solve(int col, char[][] board, List < List < String >> res, int leftRow[], int lowerDiagonal[], int upperDiagonal[]) {
        if (col == board.length) {
            res.add(construct(board));
            return;
        }

        for (int row = 0; row < board.length; row++) {
            if (leftRow[row] == 0 && lowerDiagonal[row + col] == 0 && upperDiagonal[board.length - 1 + col - row] == 0) {
                board[row][col] = 'Q';
                leftRow[row] = 1;
                lowerDiagonal[row + col] = 1;
                upperDiagonal[board.length - 1 + col - row] = 1;
                solve(col + 1, board, res, leftRow, lowerDiagonal, upperDiagonal);
                board[row][col] = '.';
                leftRow[row] = 0;
                lowerDiagonal[row + col] = 0;
                upperDiagonal[board.length - 1 + col - row] = 0;
            }
        }
    }

    static List < String > construct(char[][] board) {
        List < String > res = new LinkedList < String > ();
        for (int i = 0; i < board.length; i++) {
            String s = new String(board[i]);
            res.add(s);
        }
        return res;
    }

### Other Techniques
- Instead of hashtables, we could have used nested loops to check left, upperLeft, lowerLeft sides

### Complexity
1. Time Complexity - O(N! * N)
2. Space Complexity - O(N)