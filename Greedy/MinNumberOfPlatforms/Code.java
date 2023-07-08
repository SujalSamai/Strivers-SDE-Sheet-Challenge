package Greedy.MinNumberOfPlatforms;

import java.util.Arrays;

public class Code {
    public static int calculateMinPlatforms(int at[], int dt[], int n){
        Arrays.sort(at);
        Arrays.sort(dt);
        int platform=1, result=1;
        int i=1, j=0;
        while (i<n && j<n){
            if (at[i]<=dt[j]){
                platform++;
                i++;
            }else if(at[i]>dt[j]){
                platform--;
                j++;
            }
            result=Math.max(result, platform);
        }
        return result;
    }
}
