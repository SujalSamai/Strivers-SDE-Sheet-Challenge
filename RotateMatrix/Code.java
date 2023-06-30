package RotateMatrix;

import java.util.ArrayList;

public class Code {

    //leetcode one
    public void rotate(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        //transpose the matrix i.e., convert rows into cols & cols into rows
        for(int i=0; i<rows; i++){
            for(int j=i; j<cols; j++){
                int temp= matrix[i][j];
                matrix[i][j]= matrix[j][i];
                matrix[j][i]=temp;
            }
        }

        //reverse each row to get the result
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols/2; j++){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[i][rows-1-j];
                matrix[i][rows-1-j]= temp;
            }
        }
    }
}
