package RotateMatrix;

import java.util.ArrayList;

public class Code {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        ArrayList<Integer> row1 = new ArrayList<>();
        row1.add(1);
        row1.add(2);
        row1.add(3);
        matrix.add(row1);
        ArrayList<Integer> row2 = new ArrayList<>();
        row2.add(4);
        row2.add(5);
        row2.add(6);
        matrix.add(row2);
        ArrayList<Integer> row3 = new ArrayList<>();
        row3.add(7);
        row3.add(8);
        row3.add(9);
        matrix.add(row3);

        rotateMatrix(matrix, matrix.size(), matrix.get(0).size());

        for (ArrayList<Integer> row : matrix) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
    public static void rotateMatrix(ArrayList<ArrayList<Integer>> mat, int n, int m) {
        int u = 0;
        int d = n-1;
        int l = 0;
        int r = m-1;

        while (l<r && u<d) {
            int prev = mat.get(u+1).get(l);
            for (int i=l;i<=r;i++) {
                int curr = mat.get(u).get(i);
                mat.get(u).set(i,prev);
                prev = curr;
            }
            u++;
            for (int i=u;i<=d;i++) {
                int curr = mat.get(i).get(r);
                mat.get(i).set(r,prev);
                prev = curr;
            }
            r--;
            for (int i=r;i>=l;i--) {
                int curr = mat.get(d).get(i);
                mat.get(d).set(i,prev);
                prev = curr;
            }
            d--;
            for (int i=d;i>=u;i--) {
                int curr = mat.get(i).get(l);
                mat.get(i).set(l,prev);
                prev = curr;
            }
            l++;
        }
    }

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
