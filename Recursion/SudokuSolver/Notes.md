### Question
- Write a program to solve a Sudoku puzzle by filling the empty cells. 
- A sudoku solution must satisfy all of the following rules:
- Each of the digits 1-9 must occur exactly once in each row.
- Each of the digits 1-9 must occur exactly once in each column. 
- Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid. 
- The '.' character indicates empty cells.

### Sample Input
    [
        ["5","3",".",".","7",".",".",".","."],
        ["6",".",".","1","9","5",".",".","."],
        [".","9","8",".",".",".",".","6","."],
        ["8",".",".",".","6",".",".",".","3"],
        ["4",".",".","8",".","3",".",".","1"],
        ["7",".",".",".","2",".",".",".","6"],
        [".","6",".",".",".",".","2","8","."],
        [".",".",".","4","1","9",".",".","5"],
        [".",".",".",".","8",".",".","7","9"]
    ]

### Sample Output
    [
        ["5","3","4","6","7","8","9","1","2"],
        ["6","7","2","1","9","5","3","4","8"],
        ["1","9","8","3","4","2","5","6","7"],
        ["8","5","9","7","6","1","4","2","3"],
        ["4","2","6","8","5","3","7","9","1"],
        ["7","1","3","9","2","4","8","5","6"],
        ["9","6","1","5","3","7","2","8","4"],
        ["2","8","7","4","1","9","6","3","5"],
        ["3","4","5","2","8","6","1","7","9"]
    ]

### Solution
- Let’s see the step by step approach. Our main recursive function(solve()) is going to just do a plain matrix traversal of the sudoku board. When we find an empty cell, we pause and try to put all available numbers(1 – 9) in that particular empty cell. 
- We need another loop to do that. But wait, we forgot one thing – the board has to satisfy all the conditions, right? So, for that we have another function(isValid()) which will check whether the number we have inserted into that empty cell will not violate any conditions. 
- If it is violating, we try with the next number. If it is not, we call the same function recursively, but this time with the updated state of the board. Now, as usual it tries to fill the remaining cells in the board in the same way. 
- Now we’ll come to the returning values. If at any point we cannot insert any numbers from 1 – 9 in a particular cell, it means the current state of the board is wrong and we need to backtrack. 
- An important point to follow is, we need to return false to let the parent function(which is called this function) know that we cannot fill this way. This will serve as a hint to that function, that it needs to try with the next possible number.
- If a recursive call returns true, we can assume that we found one possible way of filling and we simply do an early return.
- Validating -> We loop from 0 to 8 and check the values – board[i][col] (1st condition) and board[row][i] (2nd condition), whether the number is already included. For the 3rd condition – the expression (3 * (row / 3) + i / 3) evaluates to the row numbers of that 3×3 submatrix and the expression (3 * (col / 3) + i % 3) evaluates to the column numbers.

### Code
    public static boolean solveSudoku(char[][] board){
        //check each cell and if it is empty
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j]=='.'){
                    //try all possible numbers
                    for (char c = '1'; c <= '9'; c++) {
                        //if the number is valid, add it to the board
                        if (isValid(board, i, j, c)){
                            board[i][j]=c;

                            //once we added a number, search for next empty cell recursively
                            if (solveSudoku(board)){
                                return true;
                            }else{
                                //if this path couldn't get right answer, backtrack and remove our answer
                                board[i][j]='.';
                            }
                        }
                    }
                    //if no number can give result, return false
                    return false;
                }
            }
        }
        //if we have traversed whole matrix, then we got answer
        return true;
    }

    private static boolean isValid(char[][] board, int row, int col, char c) {
        for (int i = 0; i < 9; i++) {
            //checking the whole col
            if (board[i][col]==c){
                return false;
            }
            //checking the whol row
            if (board[row][i]==c){
                return false;
            }

            //checking the sub-matrix, by finding indexes
            int subRow= 3* (row/3) + i/3;
            int subCol= 3* (col/3) + i%3;
            if (board[subRow][subCol]==c){
                return false;
            }
        }
        return true;
    }

### Other Techniques
- N/A

### Complexity
1. Time Complexity - O(9(n ^ 2))
2. Space Complexity - O(1)