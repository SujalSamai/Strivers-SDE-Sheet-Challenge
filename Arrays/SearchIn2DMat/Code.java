package Arrays.SearchIn2DMat;

import java.util.ArrayList;

public class Code {
    static boolean searchMatrix(ArrayList<ArrayList<Integer>> mat, int target) {
        int row= 0;
        int col= mat.get(0).size()-1;
        while (row<mat.size() && col>=0){
            if(mat.get(row).get(col)==target){
                return true;
            }else if(mat.get(row).get(col)<target){
                row++;
                continue;
            }else if(mat.get(row).get(col)>target){
                col--;
            }
        }
        return false;
    }
}
