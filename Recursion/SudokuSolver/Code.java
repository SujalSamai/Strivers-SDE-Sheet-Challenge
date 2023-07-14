package Recursion.SudokuSolver;

public class Code {
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
}
