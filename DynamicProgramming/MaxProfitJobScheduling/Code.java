package DynamicProgramming.MaxProfitJobScheduling;

import java.util.Arrays;

public class Code {
    static class Job {
        public int start, end, profit;
        Job(int start, int end, int profit) {
            this.start = start;
            this.end = end;
            this.profit = profit;
        }
    }

    public int jobScheduling(int[] start, int[] end, int[] profit){
        int n= start.length;
        int[] table = new int[n];
        Arrays.fill(table, -1);
        Job[] jobs = new Job[n];
        for (int i = 0; i < n; i++) {
            jobs[i] = new Job(start[i], end[i], profit[i]);
        }

        Arrays.sort(jobs, (j1, j2)-> Integer.compare(j1.start, j2.start));
        return helper(jobs, 0, n, table);
    }

    private int helper(Job[] jobs, int ind, int n, int[] table) {
        if (ind>=n) return 0;
        if (table[ind]!=-1) return table[ind];

        int take = jobs[ind].profit;
        int nonConflicting = findIndex(jobs, ind, n);
        if (nonConflicting!= -1){
            take += helper(jobs, nonConflicting, n, table);
        }
        int notTake = helper(jobs, ind+1, n, table);
        return table[ind]= Math.max(take, notTake);
    }

    private int findIndex(Job[] jobs, int ind, int n) {
        int start =ind+1, end=n-1, ans=-1;
        while (start<=end){
            int mid= (start+end)/2;
            if (jobs[ind].end <= jobs[mid].start){
                ans= mid;
                end= mid-1;
            }else start=mid+1;
        }
        return ans;
    }
}
