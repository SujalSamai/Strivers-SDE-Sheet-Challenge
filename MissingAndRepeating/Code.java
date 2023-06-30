package MissingAndRepeating;

import java.util.ArrayList;
import java.util.Arrays;

public class Code {
    public static void main(String[] args) {
        ArrayList<Integer> list=new ArrayList<>();
        list.add(6);
        list.add(4);
        list.add(3);
        list.add(5);
        list.add(5);
        list.add(1);
        System.out.println(Arrays.toString(missingAndRepeating(list, list.size())));
    }

    public static int[] missingAndRepeating(ArrayList<Integer> arr, int n) {
        // Write your code here
        int[] hash=new int[n+1];
        for (int i = 0; i < n; i++) {
            hash[arr.get(i)]++;
        }

        int ans[] = new int[2];
        for (int i = 1; i <= n; i++) {
            if(hash[i]==2) ans[1]=i;
            else if (hash[i]==0) ans[0]=i;
        }
        return ans;
    }
}
