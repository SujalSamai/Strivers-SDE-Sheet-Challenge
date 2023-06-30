package LongestSubarrZeroSum;

import java.util.ArrayList;
import java.util.HashMap;

public class Code {
    public static int LongestSubsetWithZeroSum(ArrayList<Integer> arr){
        HashMap<Integer, Integer> map=new HashMap<>();
        int maxi=0, sum=0;

        for (int i = 0; i < arr.size(); i++) {
            sum+= arr.get(i);
            if (map.containsKey(sum)){
                maxi=Math.max(maxi, (i-map.get(sum)));
            }else if(sum==0){
                maxi=i+1;
            }else{
                map.put(sum,i);
            }
        }
        return maxi;
    }
}
