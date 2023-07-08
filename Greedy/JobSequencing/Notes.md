### Question
- You are given a Nx2, 2-D array 'jobs' of 'N' jobs where jobs[i][0] denotes the deadline of i-th job and jobs[i][1] denotes the profit associated with the job.
- You'll make a certain profit if you complete the job within the deadline associated with it. Each job takes 1 unit of time to be completed, and you can schedule one job at a particular time. Your task is to find the max profit.

### Sample Input
    at = [2,2,1,1], dt= [30,40,10,10]
    at = [2,4,1,3,5], dt= [24, 40, 5, 50, 60]

### Sample Output
    70
    180

### Solution
- The strategy to maximize profit should be to pick up jobs that offer higher profits. Hence we should sort the jobs in descending order of profit.
- Now say if a job has a deadline of 4 we can perform it anytime between day 1-4, but it is preferable to perform the job on its last day. This leaves enough empty slots on the previous days to perform other jobs.
- Sort the jobs in descending order of profit. 
- If the maximum deadline is x, make an array of size x .Each array index is set to -1 initially as no jobs have been performed yet. 
- For every job check if it can be performed on its last day. 
- If possible mark that index with the job id and add the profit to our answer. 
- If not possible, loop through the previous indexes until an empty slot is found.

### Code
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

### Edge Cases
- NA

### Other Techniques
- NA

### Complexity
1. Time Complexity - O(NlogN) + O(N*M)
2. Space Complexity - O(M), where M is the max deadline