### Question
- You have been given two arrays, 'at' & 'dt', representing the arrival and departure times of all trains that reach the railway station.
- Your task is to find the minimum platforms required for the railway station so that no trains need to wait.

### Sample Input
    at = [900, 940, 950, 1100, 1500, 1800], dt= [910, 1200, 1120, 1130, 1900, 2000]
    at = [100, 200, 300, 400], dt= [200, 300, 400, 500]

### Sample Output
    3
    2

### Solution
- At first we need to sort both arrays. When the events will be sorted, it will be easy to track the count of trains that have arrived but not departed yet.
- The total platforms needed at one time can be found by taking the difference between arrivals and departures at that time and the maximum value of all times will be the final answer.
- If(arr[i]<=dep[j]) means if arrival time is less than or equal to the departure time then- we need one more platform. So increment count as well as increment i.
- If(arr[i]>dep[j]) means the arrival time is more than the departure time then- we have one extra platform which we can reduce. So decrement count but increment j

### Code
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

### Edge Cases
- NA

### Other Techniques
- Nested Loops

### Complexity
1. Time Complexity - O(NlogN)
2. Space Complexity - O(N)