package Arrays.CountSubarrXORK;

import java.util.ArrayList;
import java.util.HashMap;

public class Code {
    public static void main(String[] args) {
        ArrayList<Integer> arr=new ArrayList<>();
        arr.add(5);
        arr.add(3);
        arr.add(8);
        arr.add(3);
        arr.add(10);
        System.out.println(subarraysXor(arr,8));
    }
    public static int subarraysXor(ArrayList<Integer> arr, int x){
        int xr=0;
        HashMap<Integer, Integer> map=new HashMap<>();
        map.put(xr,1);
        int count=0;

        for (int i = 0; i < arr.size(); i++) {
            xr=xr^arr.get(i);
            int k= xr^x;

            if (map.containsKey(k)){
                count+=map.get(k);
            }

            map.put(xr, map.getOrDefault(xr, 0)+1);
        }
        return count;
    }
}
