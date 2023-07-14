package Recursion.NQueens;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Code {
    public static List<List<String>> solveNQueens(int n){
        //create nxn chess board
        char[][] board= new char[n][n];
        //fill them as empty
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j]= '.';
            }
        }

        List<List<String>> res= new ArrayList<>();
        int[] leftRow= new int[n];  //hashtable for checking left side
        int[] upDiagonal= new int[2*n-1]; //hashtable to check upper diagonal
        int[] lowDiagonal= new int[2*n-1];  //hashtable to check lower diagonal
        solve(0, board, res, leftRow, upDiagonal, lowDiagonal);
        return res;
    }

    private static void solve(int col, char[][] board, List<List<String>> res, int[] leftRow, int[] upDiagonal, int[] lowDiagonal) {
        int n= board.length;
        if (col== n){
            //if all the col are traversed, we got out answer, convert the board matrix to string List and add to answer
            res.add(construct(board));
            return;
        }

        for (int row = 0; row < n; row++) {
            //we only need to check left, upperDiagonal & lowerDiagonal of left side, as we haven't added a character to right side yet
            if (leftRow[row]==0 && lowDiagonal[row+col]==0 && upDiagonal[n-1+col-row]==0){
                //if those three places doesn't have queen, we can add a queen
                board[row][col]='Q';
                leftRow[row]=1;
                lowDiagonal[row+col]=1;
                upDiagonal[n-1+col-row]=1;

                //now move and check the next col
                solve(col+1, board, res, leftRow, upDiagonal, lowDiagonal);

                //if we can't find answer, remove our answer while backtracking
                board[row][col]='.';
                leftRow[row]=0;
                lowDiagonal[row+col]=0;
                upDiagonal[n-1+col-row]=0;
            }
        }
    }

    private static List<String> construct(char[][] board) {
        List<String> res= new LinkedList<String>();
        for (int i = 0; i < board.length; i++) {
            //convert row to string and add to answer List
            String s= new String(board[i]);
            res.add(s);
        }
        return res;
    }
}
