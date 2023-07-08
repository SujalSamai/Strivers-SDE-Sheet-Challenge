package Greedy.JobSequencing;

import java.util.Arrays;

public class Code {

    public static int jobScheduling(int[][] jobs) {
        int n=jobs.length;
        Arrays.sort(jobs, (a,b)-> (b[1]-a[1]));
        int ans=0;

        int maxi=0;
        //finding the max deadline to create an array of its size
        for (int[] job : jobs) {
            if (job[0] > maxi) {
                maxi = job[0];
            }
        }

        int[] res=new int[maxi+1];
        Arrays.fill(res, -1);

        for (int[] job : jobs) {
            int deadline = job[0];
            for (int j = deadline; j > 0; j--) {
                if (res[j] == -1) {
                    res[j] = 1;
                    ans += job[1];
                    break;
                }
            }
        }
        return ans;
    }
}
