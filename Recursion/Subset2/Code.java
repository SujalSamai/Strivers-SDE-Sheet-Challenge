package Recursion.Subset2;

import java.util.ArrayList;
import java.util.Arrays;

public class Code {
    public static ArrayList<ArrayList<Integer>> uniqueSubsets(int n, int[] arr){
        Arrays.sort(arr);   //to bring together the duplicates side by side
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        findSubsets(0, arr, new ArrayList<Integer>(), ans);
        return ans;
    }

    private static void findSubsets(int ind, int[] arr, ArrayList<Integer> list, ArrayList<ArrayList<Integer>> ans) {
        ans.add(new ArrayList<>(list));
        for (int i = ind; i < arr.length; i++) {
            if (i!=ind && arr[i]==arr[i-1]) continue;   //if duplicate found skip
            list.add(arr[i]);
            findSubsets(i+1, arr, list, ans);
            list.remove(list.size()-1);
        }
    }
}
