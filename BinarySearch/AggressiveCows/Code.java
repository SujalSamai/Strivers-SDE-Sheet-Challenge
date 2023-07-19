package BinarySearch.AggressiveCows;

import java.util.Arrays;

public class Code {
    public static int aggressiveCows(int[] stalls, int k){
        int n=stalls.length;
        Arrays.sort(stalls);

        int low=1, high= stalls[n-1] - stalls[0];

        while (low<=high){
            int mid= (low+high)/2;
            if (canWePlace(stalls,mid,k,n)){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return high;
    }

    private static boolean canWePlace(int[] stalls, int dist, int k, int n) {
        int cntCows=1;  //no. of cows placed
        int last= stalls[0];    //position of last placed cow
        for (int i = 1; i < n; i++) {
            if (stalls[i] - last >= dist){      //if the current distance >= given distance, add one more cow
                cntCows++;
                last = stalls[i];   //update the position of last cow
            }
            if (cntCows >= k) return true;
        }
        return false;
    }
}
