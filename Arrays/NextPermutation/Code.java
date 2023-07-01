package Arrays.NextPermutation;

import java.util.ArrayList;

public class Code {
    public static ArrayList<Integer> nextPermutation(ArrayList<Integer> permutation) {
        if(permutation.size()<=1 || permutation==null) return permutation;
        int i= permutation.size()-2;

        while (i>=0 && permutation.get(i)>=permutation.get(i+1)) i--;
        if(i>=0){
            int j= permutation.size()-1;
            while (permutation.get(j)<=permutation.get(i)) j--;
            swap(permutation,i,j);
        }
        reverse(permutation, i+1, permutation.size()-1);
        return permutation;
    }

    private static void reverse(ArrayList<Integer> permutation, int i, int j) {
        while (i<j){
            swap(permutation, i++, j--);
        }
    }

    private static void swap(ArrayList<Integer> permutation, int i, int j) {
        int temp= permutation.get(i);
        permutation.set(i, permutation.get(j));
        permutation.set(j,temp);
    }
    
}
