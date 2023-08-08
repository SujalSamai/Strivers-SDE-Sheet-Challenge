package Arrays.DistinctNumbersInWindows;

import java.util.ArrayList;
import java.util.HashMap;

public class Code {
    public static ArrayList<Integer> countDistinctElements(ArrayList<Integer> arr, int k) {
        HashMap<Integer, Integer> map= new HashMap<>();
        ArrayList<Integer> ans= new ArrayList<>();

        for (int i = 0; i < k; i++) {
            map.put(arr.get(i), map.getOrDefault(arr.get(i),0)+1);
        }
        ans.add(map.size());

        int p=0;
        for (int i = k; i < arr.size(); i++) {
            map.put(arr.get(p), map.getOrDefault(arr.get(p),0)-1);
            if (map.get(arr.get(p))==0){
                map.remove(arr.get(p));
            }
            p++;
            map.put(arr.get(i), map.getOrDefault(arr.get(i),0)+1);
            ans.add(map.size());
        }
        return ans;
    }
}
