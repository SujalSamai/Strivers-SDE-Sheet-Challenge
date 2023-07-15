package Recursion.PermutationSeq;

import java.util.ArrayList;

public class Code {
    public static String getPermutation(int n, int k){
        int fact=1;
        //find the factorial of n & push all the n integers into an array
        ArrayList<Integer> arr= new ArrayList<>();
        for (int i = 1; i <n; i++) {
            fact= fact*i;
            arr.add(i);
        }
        arr.add(n);
        String ans="";
        //since we are using 0 based indexing, k will become k-1
        k=k-1;
        while (true){
            ans= ans + "" + arr.get(k/fact);
            arr.remove(k/fact);
            if (arr.size()==0) break;

            k=k%fact;
            fact= fact/arr.size();
        }
        return ans;
    }
}
